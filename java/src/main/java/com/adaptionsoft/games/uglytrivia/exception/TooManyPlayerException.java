package com.adaptionsoft.games.uglytrivia.exception;

public class TooManyPlayerException extends RuntimeException {

    public TooManyPlayerException() {
    }

    public TooManyPlayerException(String message) {
        super(message);
    }

    public TooManyPlayerException(String message, Throwable cause) {
        super(message, cause);
    }

    public TooManyPlayerException(Throwable cause) {
        super(cause);
    }

    public TooManyPlayerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
