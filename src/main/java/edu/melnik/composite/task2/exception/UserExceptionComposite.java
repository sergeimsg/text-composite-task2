package edu.melnik.composite.task2.exception;

public class UserExceptionComposite extends Exception{

    public UserExceptionComposite() {
        super();
    }

    public UserExceptionComposite(String message) {
        super(message);
    }

    public UserExceptionComposite(String message, Throwable cause) {
        super(message, cause);
    }

    public UserExceptionComposite(Throwable cause) {
        super(cause);
    }
}
