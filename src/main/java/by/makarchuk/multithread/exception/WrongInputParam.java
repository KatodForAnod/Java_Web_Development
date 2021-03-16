package by.makarchuk.multithread.exception;

public class WrongInputParam extends Exception{
    public WrongInputParam() {
        super();
    }

    public WrongInputParam(String message) {
        super(message);
    }

    public WrongInputParam(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongInputParam(Throwable cause) {
        super(cause);
    }
}
