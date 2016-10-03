package org.led.simba.user;

import org.led.simba.common.DomainException;

/**
 * Created by Nghia on 03-10-2016.
 */
public class UserException extends DomainException {
    public static final int INVALID_ROLE = 3;
    public static final int DUPLICATE_LOGIN_ID= 4;
    public static final int INVALID_PASSWORD= 5;

    public UserException(Throwable cause, int errorCode) {
        super(cause, Type.user.getDomainCode(), errorCode);
    }

    public UserException(int errorCode) {
        super(Type.user.getDomainCode(), errorCode);
    }

    public UserException(String message, Throwable cause, int errorCode) {
        super(message, cause, Type.user.getDomainCode(), errorCode);
    }

    public UserException(String message, int errorCode) {
        super(message, Type.user.getDomainCode(), errorCode);
    }
}
