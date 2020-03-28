package p05CustomException.exceptions;

public class InvalidPersonNameException extends IllegalArgumentException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public InvalidPersonNameException(String msg) {
        super(msg);
    }

}
