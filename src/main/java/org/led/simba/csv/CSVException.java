package org.led.simba.csv;

import org.led.simba.common.DomainException;
import org.supercsv.util.CsvContext;

import java.util.Comparator;

/**
 * Created by nghialun on 12/10/2016.
 */
public class CSVException extends DomainException {
    private static final long serialVersionUID = 4422876296587951620L;
    private static final int domainCode = Type.csv.getDomainCode();
    public static final int CSV_FILE_ERROR = 10;
    public static final int CSV_USER_EMPTY_DATA = 11;
    public static final int CSV_COLUMN_INVALID = 12;
    public static final int CSV_FILE_NOT_FOUND = 14;
    public static final int S3_READ_FILE_ERROR = 15;
    public static final int CSV_EXPORT_CSV_FAILED = 16;

    public CSVException(int errorCode) {
        super(domainCode, errorCode);
    }

    public CSVException(Throwable cause, int errorCode) {
        super(cause, domainCode, errorCode);
    }

    public CSVException(String message, int errorCode) {
        super(message, domainCode, errorCode);
    }

    public CSVException(String message, Throwable cause, int errorCode) {
        super(message, cause, domainCode, errorCode);
    }

    public static class CSVError {

        public static Comparator<CSVError> comparator = new Comparator<CSVError>() {

            @Override
            public int compare(CSVError o1, CSVError o2) {
                return o1.line - o2.line;
            }
        };

        private int line;
        private String column;
        private int errorCode;
        private String message;

        public CSVError() {
        }

        public CSVError(int line, String column, int errorCode, String message) {
            this.line = line;
            this.column = column;
            this.errorCode = errorCode;
            this.message = message;
        }

        public CSVError(String[] header, CsvContext csvContext, int errorCode) {
            this.line = csvContext.getLineNumber();
            this.column = header[csvContext.getColumnNumber() - 1];
            this.errorCode = errorCode;
        }

        public int getLine() {
            return line;
        }

        public void setLine(int line) {
            this.line = line;
        }

        public String getColumn() {
            return column;
        }

        public void setColumn(String column) {
            this.column = column;
        }

        public int getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(int errorCode) {
            this.errorCode = errorCode;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + errorCode;
            result = prime * result + line;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            CSVError other = (CSVError) obj;
            if (errorCode != other.errorCode)
                return false;
            if (line != other.line)
                return false;
            return true;
        }

        @Override
        public String toString() {
            return line + " " + column + " " + errorCode;
        }

    }
}
