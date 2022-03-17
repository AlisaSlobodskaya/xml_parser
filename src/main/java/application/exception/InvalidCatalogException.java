package application.exception;

public class InvalidCatalogException extends RuntimeException {
    public InvalidCatalogException(String message) {
        super(message);
    }
}
