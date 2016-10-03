package org.led.simba.product;

import org.led.simba.common.DomainException;

/**
 * Created by Nghia on 03-10-2016.
 */
public class ProductItemException extends DomainException{
    public ProductItemException(Throwable cause, int errorCode) {
        super(cause, DomainException.Type.product.getDomainCode(), errorCode);
    }

    public ProductItemException(int errorCode) {
        super(DomainException.Type.product.getDomainCode(), errorCode);
    }

    public ProductItemException(String message, Throwable cause, int errorCode) {
        super(message, cause, DomainException.Type.product.getDomainCode(), errorCode);
    }

    public ProductItemException(String message, int errorCode) {
        super(message, DomainException.Type.product.getDomainCode(), errorCode);
    }
}
