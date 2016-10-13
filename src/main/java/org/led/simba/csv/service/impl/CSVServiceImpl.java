package org.led.simba.csv.service.impl;

import org.apache.commons.collections.CollectionUtils;
import org.led.simba.csv.CSVException;
import org.led.simba.csv.CSVException.CSVError;
import org.led.simba.csv.CSVProcessors;
import org.led.simba.csv.service.CSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.exception.SuperCsvConstraintViolationException;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by nghialun on 12/10/2016.
 */
@Service
public class CSVServiceImpl implements CSVService {
    private static final int START_DATA_LINE = 2;

    @Autowired
    private S3ServiceImpl s3Service;

    /**
     * using for local file
     */
    @Override
    public <P extends CellProcessor, T> List<T> parseFromCSVToBean(String[] header, String[] nameMapping,
            String linkToFile, String charset, String protocol, List<CSVException.CSVError> csvErrors, P[] processors,
            Class<T> clazz) {
        try {
            if (!csvErrors.isEmpty()) {
                return Collections.emptyList();
            }

            List<T> data = readToBean(linkToFile, nameMapping, clazz, charset, processors);

            for (P cell : processors) {
                if (cell instanceof CSVProcessors)
                    csvErrors.addAll(((CSVProcessors) cell).getErrors());
            }

            if (CollectionUtils.isEmpty(data)) {
                csvErrors.add(new CSVException.CSVError(0, "", CSVException.CSV_USER_EMPTY_DATA, "File empty."));
            }
            return data;

        } catch (SuperCsvConstraintViolationException e) {
            csvErrors.add(new CSVException.CSVError(header, e.getCsvContext(), CSVException.CSV_COLUMN_INVALID));
        }
        return Collections.emptyList();
    }

    /**
     * using for s3 link
     */
    public <P extends CellProcessor, T> List<T> parseFromS3ToBean(String[] header, String[] nameMapping, String s3Link,
            String charset, String protocol, List<CSVError> csvErrors, P[] processors, Class<T> clazz) {
        try {

            if (!csvErrors.isEmpty()) {
                return Collections.emptyList();
            }

            List<T> data = readToBean(getStreamFromLink(s3Link, charset), nameMapping, clazz, charset, processors);

            for (P cell : processors) {
                if (cell instanceof CSVProcessors)
                    csvErrors.addAll(((CSVProcessors) cell).getErrors());
            }

            if (CollectionUtils.isEmpty(data)) {
                csvErrors.add(new CSVException.CSVError(0, "", CSVException.CSV_USER_EMPTY_DATA, "File empty."));
            }
            return data;

        } catch (SuperCsvConstraintViolationException e) {
            csvErrors.add(new CSVError(header, e.getCsvContext(), CSVException.CSV_COLUMN_INVALID));
        }
        return Collections.emptyList();
    }

    private InputStream getStreamFromLink(String linkToFile, String charset) {
        return s3Service.getStreamFromS3(linkToFile, charset);
    }

    public static <E> List<E> readToBean(String pathToFile, final String[] nameMapping, Class<E> bean, String charset,
            CellProcessor... processors) {
        List<E> allValues = new ArrayList<E>();

        int line = START_DATA_LINE;
        try (BufferedInputStream bufferedStream = new BufferedInputStream(new FileInputStream(pathToFile));
                InputStreamReader inputReader = new InputStreamReader(bufferedStream, charset);
                ICsvBeanReader beanReader = new CsvBeanReader(new BufferedReader(inputReader),
                        CsvPreference.STANDARD_PREFERENCE);) {

            // move the file cursor to the first row containing data (the second
            // row from the top)
            beanReader.getHeader(false);

            E currentRowData = null;
            // Loop to read line by line.
            if (processors == null || processors.length == 0) {
                while ((currentRowData = beanReader.read(bean, nameMapping)) != null) {
                    allValues.add(currentRowData);
                    line++;
                }
            } else {
                while ((currentRowData = beanReader.read(bean, nameMapping, processors)) != null) {
                    allValues.add(currentRowData);
                    line++;
                }
            }

        } catch (FileNotFoundException e) {
            throw new CSVException("File not found", CSVException.CSV_FILE_NOT_FOUND);
        } catch (IllegalArgumentException e2) {
            throw new IllegalArgumentException(String.valueOf(line), e2);

        } catch (IOException e) {
            throw new CSVException("Khong the load duoc file", CSVException.CSV_FILE_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allValues;
    }

    public static <E> List<E> readToBean(InputStream inputStream, final String[] nameMapping, Class<E> bean,
            String charset, CellProcessor... processors) {
        List<E> allValues = new ArrayList<E>();

        try (//
                BufferedInputStream bufferedStream = new BufferedInputStream(inputStream);
                InputStreamReader inputReader = new InputStreamReader(bufferedStream, charset);
                ICsvBeanReader beanReader = new CsvBeanReader(new BufferedReader(inputReader),
                        CsvPreference.STANDARD_PREFERENCE);) {

            // move the file cursor to the first row containing data (the second
            // row from the top)
            beanReader.getHeader(false);

            E currentRowData = null;
            // Loop to read line by line.
            if (processors == null || processors.length == 0) {
                while ((currentRowData = beanReader.read(bean, nameMapping)) != null) {
                    allValues.add(currentRowData);
                }
            } else {
                while ((currentRowData = beanReader.read(bean, nameMapping, processors)) != null) {
                    allValues.add(currentRowData);
                }
            }
        } catch (IOException e) {
            throw new CSVException(CSVException.CSV_FILE_ERROR);
        }
        return allValues;
    }
}
