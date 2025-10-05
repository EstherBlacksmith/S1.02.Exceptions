package theater;

public class FreeSeatException extends RuntimeException {
    private String message = null;

    public FreeSeatException(String message) {
        super(message);
        this.message = message;
    }

}
