package lec05.glab.exceptions;

import lec03.glab.employee.Executive;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/4/13
 * Time: 1:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class BadUserDataException extends IOException {

    /**
     * Constructs an {@code IOException} with the specified detail message.
     *
     * @param message The detail message (which is saved for later retrieval
     *                by the {@link #getMessage()} method)
     */
    public BadUserDataException(String message) {
        super("You are a bad user " + message);
    }
}
