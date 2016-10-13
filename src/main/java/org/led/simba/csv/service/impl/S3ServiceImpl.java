package org.led.simba.csv.service.impl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.UUID;

import org.led.simba.csv.CSVException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;

@Service
public class S3ServiceImpl {
    private static final String CONTENT_TYPE = "application/octet-stream";

    @Autowired
    private AmazonS3DataSource s3DataSource;

    @Autowired
    Environment environment;

    private static final String REPLACE_SPECIAL_CHARACTER = "_";
    private static final String UNDERLINE = "_";
    private static final String EXTENSION_FILE_NAME = ".csv";
    private static final int REMOVE_SLASH = 1;

    public String putObjectWithPresignedUrl(String localPathFile, boolean isDeleteFile, String fileName,
            boolean appendTime) {
        File file = null;
        BufferedInputStream bis = null;
        try {
            file = new File(localPathFile);
            bis = new BufferedInputStream(new FileInputStream(file));

            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType(CONTENT_TYPE);
            fileName = processFileName(fileName, appendTime);
            objectMetadata.setContentDisposition("attachment;filename*= UTF-8''" + encodeURI(fileName));
            String key = UUID.randomUUID().toString();
            try {
                s3DataSource.putObject(
                        new PutObjectRequest(environment.getProperty("s3.bucketName"), key, bis, objectMetadata));
            } catch (Exception e) {
                e.printStackTrace();
            }

            Date expiration = new Date();
            long time = expiration.getTime() + environment.getProperty("s3.expiration-time", Long.class);
            expiration.setTime(time);

            GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(
                    environment.getProperty("s3.bucketName"), key);
            generatePresignedUrlRequest.setMethod(HttpMethod.GET);
            generatePresignedUrlRequest.setExpiration(expiration);

            return s3DataSource.putObjectWithPresignedUrl(generatePresignedUrlRequest).toString();
        } catch (IOException e) {
            throw new CSVException("Can not read csv file from link.", CSVException.AN_ERROR_HAS_OCCURRED);
        } finally {
            if (file != null) {
                if (isDeleteFile) {
                    file.delete();
                }
            }

            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                }
            }
        }
    }

    /**
     * remove special characters which unsupported in OS: \/:"*?|<> and replace by underline character
     * 
     * return filename with format: {fileName}_{miliseconds}.csv
     * 
     * @param appendTime
     */
    private String processFileName(String fileName, boolean appendTime) {
        fileName = fileName.replaceAll("\\\\", REPLACE_SPECIAL_CHARACTER).replaceAll("/", REPLACE_SPECIAL_CHARACTER)
                .replaceAll(":", REPLACE_SPECIAL_CHARACTER).replaceAll("\\*", REPLACE_SPECIAL_CHARACTER)
                .replaceAll("\\?", REPLACE_SPECIAL_CHARACTER).replaceAll("\"", REPLACE_SPECIAL_CHARACTER)
                .replaceAll("<", REPLACE_SPECIAL_CHARACTER).replaceAll("\\|", REPLACE_SPECIAL_CHARACTER)
                .replaceAll(">", REPLACE_SPECIAL_CHARACTER);
        if (!appendTime) {
            return fileName + EXTENSION_FILE_NAME;
        }

        return fileName + UNDERLINE + new Date().getTime() + EXTENSION_FILE_NAME;
    }

    public S3Object getObject(String key, String bucketName) {
        try {
            return s3DataSource.getObject(new GetObjectRequest(bucketName, key));
        } catch (Exception e) {
            throw new CSVException("An error occurred while reading file from S3.", CSVException.S3_READ_FILE_ERROR);
        }
    }

    public InputStream getStreamFromS3(String link, String charset) {
        String bucketName = environment.getProperty("s3.bucketName");
        String key = getKeyFromS3Link(link, bucketName);
        try {
            return this.getObject(key, bucketName).getObjectContent();
        } catch (Exception e) {
            throw new CSVException("An error occurred while reading file from S3.", CSVException.S3_READ_FILE_ERROR);
        }
    }

    public String getS3FileOutPut(String localPathFile) {
        File file = null;
        BufferedInputStream bis = null;
        try {
            file = new File(localPathFile);
            bis = new BufferedInputStream(new FileInputStream(file));
            if (this.putObject(localPathFile, bis, CONTENT_TYPE) == null) {
                throw new CSVException("Cannot export file.", CSVException.CSV_EXPORT_CSV_FAILED);
            }
            return environment.getProperty("csv.protocol") + "//" + environment.getProperty("s3.bucketName") + "."
                    + environment.getProperty("s3.endpoint") + "/" + localPathFile;
        } catch (IOException e) {
            throw new CSVException("Cannot export file.", CSVException.CSV_EXPORT_CSV_FAILED);
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                }
            }
        }
    }

    public PutObjectResult putObject(String key, InputStream inputStream, String contentType) {
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(contentType);

        try {
            return s3DataSource.putObject(
                    new PutObjectRequest(environment.getProperty("s3.bucketName"), key, inputStream, objectMetadata)
                            .withCannedAcl(CannedAccessControlList.PublicRead));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getKeyFromS3Link(String linkS3WithProtocol, String bucketName) {
        int beginIndex = linkS3WithProtocol.lastIndexOf(bucketName);
        // beginIndex + 1 cause by endpoint will contain / in suffix, +1 to remove slash / with key return.
        int passOverEndPointIndex = beginIndex + bucketName.length() + REMOVE_SLASH;
        return linkS3WithProtocol.substring(passOverEndPointIndex);
    }

    public static String encodeURI(String input) throws UnsupportedEncodingException {
        // after encoding: space become +, but IE cannot decode + to space, so
        // we do it for IE.
        return URLEncoder.encode(input, "UTF-8").replaceAll("\\+", "%20").replaceAll("%5F", "_");
    }
}
