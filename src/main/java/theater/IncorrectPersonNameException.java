package theater;

public class IncorrectPersonNameException extends RuntimeException {
    private String message = null;

    public IncorrectPersonNameException(String message) {
        super(message);
        this.message = message;
    }

}
