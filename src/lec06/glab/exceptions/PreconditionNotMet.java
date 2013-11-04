package lec06.glab.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/4/13
 * Time: 12:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class PreconditionNotMet extends  RuntimeException {

    public PreconditionNotMet(String message) {
        super(message);
    }
}
