package gmail.xrapalex.game.exception;

public class ValidateException extends Exception{

    public ValidateException() {
        super();
    }

    public ValidateException(String s) {
        super(s);
    }

    public ValidateException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ValidateException(Throwable throwable) {
        super(throwable);
    }
}
