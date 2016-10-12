package org.led.simba.csv.service;

import org.led.simba.csv.CSVException;
import org.supercsv.cellprocessor.ift.CellProcessor;

import java.util.List;

/**
 * Created by nghialun on 12/10/2016.
 */
public interface CSVService {
    <P extends CellProcessor, T> List<T> parseFromCSVToBean(String[] header, String[] nameMapping, String pathToFile,
                                                            String charset, String protocol, List<CSVException.CSVError> csvErrors, P[] processors, Class<T> clazz);
}
