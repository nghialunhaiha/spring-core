package org.led.simba.csv.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

@Component
public class AmazonS3DataSource extends AmazonDataSource {

    @Autowired
    Environment environment;

    private AmazonS3 amazonS3;

    public Environment getEnvironment() {
        return environment;
    }

    public PutObjectResult putObject(PutObjectRequest putObjectRequest) {
        putObjectRequest.setBucketName(environment.getProperty("s3.bucketName"));
        return amazonS3.putObject(putObjectRequest);
    }

    public URL putObjectWithPresignedUrl(GeneratePresignedUrlRequest generatePresignedUrlRequest) throws IOException {
        generatePresignedUrlRequest.setBucketName(environment.getProperty("s3.bucketName"));
        return amazonS3.generatePresignedUrl(generatePresignedUrlRequest);
    }

    public S3Object getObject(GetObjectRequest getObjectRequest) {
        return amazonS3.getObject(getObjectRequest);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        super.afterPropertiesSet();
        if (this.awsCredentials == null)
            return;

        amazonS3 = new AmazonS3Client(awsCredentials);
        if (environment.getProperty("s3.endpoint") != null)
            amazonS3.setEndpoint(environment.getProperty("s3.endpoint"));
    }

}
