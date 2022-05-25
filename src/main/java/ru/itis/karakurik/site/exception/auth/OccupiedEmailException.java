package ru.itis.karakurik.site.exception.auth;

public class OccupiedEmailException extends RuntimeException {
    public OccupiedEmailException() {
        super();
    }

    public OccupiedEmailException(String message) {
        super(message);
    }

    public OccupiedEmailException(String message, Throwable cause) {
        super(message, cause);
    }

    public OccupiedEmailException(Throwable cause) {
        super(cause);
    }

    protected OccupiedEmailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
