package theater;

public class IncorrectRowException extends RuntimeException {
    private String message = null;

    public IncorrectRowException(String message) {
        super(message);
        this.message = message;
    }
}
