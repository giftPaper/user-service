package user.exceptions;

public class RestApiException extends RuntimeException {
    public RestApiException(String message) {
        super(message);
    }
}
