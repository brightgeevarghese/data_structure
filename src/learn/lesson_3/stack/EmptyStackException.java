package learn.lesson_3.stack;

public class EmptyStackException extends RuntimeException{
    private String message;
    public EmptyStackException(String message) {
        super(message);
    }
}
