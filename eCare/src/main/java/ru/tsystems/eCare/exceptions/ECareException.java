package ru.tsystems.eCare.exceptions;

/**
 * Created by sevasan on 3/10/2015.
 */
public class ECareException extends RuntimeException {
    String message;

    public ECareException(String message) {
        super(message);
        this.message = message;
    }

    public ECareException(String message, Throwable e) {
        super(message, e);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
