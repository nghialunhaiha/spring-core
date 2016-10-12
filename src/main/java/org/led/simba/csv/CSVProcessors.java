package org.led.simba.csv;

import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.util.CsvContext;

import java.util.ArrayList;
import java.util.List;
import org.led.simba.csv.CSVException.CSVError;
/**
 * Created by nghialun on 12/10/2016.
 */
public abstract class CSVProcessors extends CellProcessorAdaptor{
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
        return null;
    }

    public class CSVOptional extends CellProcessorAdaptor {

        @Override
        public <T> T execute(Object value, CsvContext context) {
            if (value == null) {
                return null;
            }
            return next.execute(value, context);
        }

    }

    public abstract  List<CSVProcessors> getProccessors();

}
