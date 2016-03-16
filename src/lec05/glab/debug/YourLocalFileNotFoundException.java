package lec05.glab.debug;

import java.io.IOException;

/**
 * Created by ag on 10/27/2014.
 */
public class YourLocalFileNotFoundException extends IOException {

    public YourLocalFileNotFoundException(String message) {
        super("I couldn't find your local file: " + message);
    }
}
