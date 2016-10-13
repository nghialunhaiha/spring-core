package org.led.simba.product;

import org.apache.commons.lang3.StringUtils;
import org.led.simba.csv.CSVException;
import org.led.simba.csv.CSVException.CSVError;
import org.led.simba.csv.CSVProcessors;
import org.led.simba.product.ProductItem.ColorTemp;
import org.led.simba.product.ProductItem.LEDType;
import org.led.simba.product.ProductItem.PowerSource;
import org.led.simba.product.ProductItem.SubType;
import org.supercsv.util.CsvContext;

public class ProductProcessor extends CSVProcessors {

    public CSVProcessors[] getProccessors() {
        CSVProcessors[] processorses = new CSVProcessors[] { new CSVOptional(), // title
                new CSVOptional(), // rate
                new CSVOptional(), // feed back
                new CSVOptional(), // order
                new CSVOptional(), // shipment info
                new PriceProcessor(), // price
                new PriceProcessor(), // discount price
                new CSVOptional(), // deluvery time
                new CSVOptional(), // ddelivery note
                new CSVOptional(), // available status
                new SubTypeProcessor(), // sub type
                new CSVOptional(), // prodcut dscriptions
                new CSVOptional(), // colors
                new LEDTypeProcessor(), // led type
                new ColorTempProcessor(), // color temp
                new CSVOptional(), // occasion
                new CSVOptional(), // power generation
                new CSVOptional(), // leds permetter
                new NumberProcessor(), // avg life
                new CSVBool(), // water proff
                new NumberProcessor(), // voltage
                new CSVOptional(), // color temperature
                new PowerSourceProcessor(), // powerSource
                new CSVOptional() // model number
        };
        return processorses;

    }

    public class SubTypeProcessor extends ProductProcessor {

        @Override
        public <T> T execute(Object value, CsvContext context) {
            if (value == null) {
                this.errors.add(new CSVError(ProductConstant.CSV_PRD_HEADER, context, CSVException.CSV_COLUMN_INVALID));
                return null;
            }
            try {
                return super.execute(SubType.valueOf(value.toString()), context);
            } catch (Exception e) {
                this.errors.add(new CSVError(ProductConstant.CSV_PRD_HEADER, context, CSVException.CSV_COLUMN_INVALID));
                return null;
            }
        }
    }

    public class LEDTypeProcessor extends ProductProcessor {

        @Override
        public <T> T execute(Object value, CsvContext context) {
            if (value == null) {
                this.errors.add(new CSVError(ProductConstant.CSV_PRD_HEADER, context, CSVException.CSV_COLUMN_INVALID));
                return null;
            }
            try {
                return super.execute(LEDType.valueOf(value.toString()), context);
            } catch (Exception e) {
                this.errors.add(new CSVError(ProductConstant.CSV_PRD_HEADER, context, CSVException.CSV_COLUMN_INVALID));
                return null;
            }
        }

    }

    public class ColorTempProcessor extends ProductProcessor {

        @Override
        public <T> T execute(Object value, CsvContext context) {
            if (value == null) {
                this.errors.add(new CSVError(ProductConstant.CSV_PRD_HEADER, context, CSVException.CSV_COLUMN_INVALID));
                return null;
            }
            try {
                return super.execute(ColorTemp.valueOf(value.toString()), context);
            } catch (Exception e) {
                this.errors.add(new CSVError(ProductConstant.CSV_PRD_HEADER, context, CSVException.CSV_COLUMN_INVALID));
                return null;
            }
        }

    }

    public class PowerSourceProcessor extends ProductProcessor {

        @Override
        public <T> T execute(Object value, CsvContext context) {
            if (value == null) {
                this.errors.add(new CSVError(ProductConstant.CSV_PRD_HEADER, context, CSVException.CSV_COLUMN_INVALID));
                return null;
            }
            try {
                return super.execute(PowerSource.valueOf(value.toString()), context);
            } catch (Exception e) {
                this.errors.add(new CSVError(ProductConstant.CSV_PRD_HEADER, context, CSVException.CSV_COLUMN_INVALID));
                return null;
            }
        }

    }

    public class TypeProcessor extends ProductProcessor {

        @Override
        public <T> T execute(Object value, CsvContext context) {
            if (value == null) {
                this.errors.add(new CSVError(ProductConstant.CSV_PRD_HEADER, context, CSVException.CSV_COLUMN_INVALID));
                return null;
            }
            try {
                return super.execute(ProductItem.Type.valueOf(value.toString()), context);
            } catch (Exception e) {
                this.errors.add(new CSVError(ProductConstant.CSV_PRD_HEADER, context, CSVException.CSV_COLUMN_INVALID));
                return null;
            }
        }

    }

    public class NumberProcessor extends ProductProcessor {

        @Override
        public <T> T execute(Object value, CsvContext context) {
            if (value == null || StringUtils.isEmpty(value.toString().trim())) {
                return null;
            }
            try {
                return super.execute(Long.valueOf(value.toString().trim()), context);
            } catch (Exception e) {
                this.errors.add(new CSVError(ProductConstant.CSV_PRD_HEADER, context, CSVException.CSV_COLUMN_INVALID));
                return null;
            }
        }

    }

    public class PriceProcessor extends ProductProcessor {

        @Override
        public <T> T execute(Object value, CsvContext context) {
            if (value == null || StringUtils.isEmpty(value.toString().trim())) {
                return null;
            }
            try {
                return super.execute(Double.valueOf(value.toString().trim()), context);
            } catch (Exception e) {
                this.errors.add(new CSVError(ProductConstant.CSV_PRD_HEADER, context, CSVException.CSV_COLUMN_INVALID));
                return null;
            }
        }

    }
}
