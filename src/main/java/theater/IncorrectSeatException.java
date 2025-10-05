package theater;

public class IncorrectSeatException extends RuntimeException {
    private String message = null;

    public IncorrectSeatException(String message) {
        super(message);
        this.message = message;
    }
}
