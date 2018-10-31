package by.epam.tat21.naverin.exceptions;

/**
 * This class represent exception that will be thrown when there were overmuch iluminance
 */
public class IlluminanceTooMuchException extends Exception {

    public IlluminanceTooMuchException() {
        super();
    }

    public IlluminanceTooMuchException(String message) {
        super(message);
    }

}
