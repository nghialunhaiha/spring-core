package org.led.simba.csv;

import org.led.simba.csv.CSVException.CSVError;
import org.springframework.util.StringUtils;
import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.util.CsvContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nghialun on 12/10/2016.
 */
public abstract class CSVProcessors extends CellProcessorAdaptor {

    protected boolean require;
    protected List<CSVError> errors = new ArrayList<>();

    public void setErrors(List<CSVError> errors) {
        this.errors = errors;
    }

    public List<CSVError> getErrors() {
        return errors;
    }

    @Override
    public <T> T execute(Object value, CsvContext context) {
        return next.execute(value, context);
    }

    public class CSVOptional extends CSVProcessors {

        @Override
        public <T> T execute(Object value, CsvContext context) {
            if (value == null) {
                return null;
            }
            return next.execute(value, context);
        }

        @Override
        public CSVProcessors[] getProccessors() {
            return null;
        }

    }

    public class CSVBool extends CSVProcessors {
        @Override
        public Object execute(Object value, CsvContext context) {
            if (StringUtils.isEmpty(value) || value.toString().equalsIgnoreCase("false")) {
                return next.execute(false, context);
            }
            return next.execute(true, context);
        }

        @Override
        public CSVProcessors[] getProccessors() {
            return null;
        }

    }

    public abstract CSVProcessors[] getProccessors();

}
