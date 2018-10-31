package by.epam.tat21.naverin.exceptions;

/**
 * This class represent exception that will be thrown when there were lack of space appears
 */
public class SpaceUsageTooMuchException extends Exception {
    public SpaceUsageTooMuchException(){
        super();
    }

    public SpaceUsageTooMuchException(String message){
        super(message);
    }
}
