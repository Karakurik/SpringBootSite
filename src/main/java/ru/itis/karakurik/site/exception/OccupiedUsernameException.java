package ru.itis.karakurik.site.exception;

public class OccupiedUsernameException extends RuntimeException {
    public OccupiedUsernameException() {
        super();
    }

    public OccupiedUsernameException(String message) {
        super(message);
    }

    public OccupiedUsernameException(String message, Throwable cause) {
        super(message, cause);
    }

    public OccupiedUsernameException(Throwable cause) {
        super(cause);
    }

    protected OccupiedUsernameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
