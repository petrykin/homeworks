package lesson16.task2.exception;

public class WrongLoginException extends Exception {
    private String detail;

    public WrongLoginException() {
        detail = "Некорректный логин!";
    }

    public WrongLoginException(String message) {
        super(message);
        detail = message;
    }

    @Override
    public String toString() {
        return "WrongLoginException: " + detail;
    }
}
