package org.led.simba.common;

/**
 * Created by Nghia on 03-10-2016.
 */
public class DomainException extends RuntimeException {
    public static final int NOT_FOUND = 1;
    public static final int DUPLICATE = 2;
    public static final int AN_ERROR_HAS_OCCURRED = 99;

    private int domainCode;
    private int errorCode;

    public DomainException(int domainCode, int errorCode) {
        this.domainCode = domainCode;
        this.errorCode = errorCode;
    }

    public DomainException(Throwable cause, int domainCode, int errorCode) {
        super(cause);
        this.domainCode = domainCode;
        this.errorCode = errorCode;
    }

    public DomainException(String message, int domainCode, int errorCode) {
        super(message);
        this.domainCode = domainCode;
        this.errorCode = errorCode;
    }

    public DomainException(String message, Throwable cause, int domainCode, int errorCode) {
        super(message, cause);
        this.domainCode = domainCode;
        this.errorCode = errorCode;
    }

    public int getCode() {
        return (domainCode * 100) + errorCode;
    }

    public enum Type {
        user(2), product(3);
        private int domainCode;

        Type(int domainCode) {
            this.domainCode = domainCode;
        }

        public int getDomainCode() {
            return domainCode;
        }
    }
}
