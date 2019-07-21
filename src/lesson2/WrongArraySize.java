package lesson2;

public class WrongArraySize extends RuntimeException {
    public WrongArraySize(String s) {
        super(s);
    }

    public WrongArraySize() {
        super();

    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }
}
