package exception;

public class InvalidQuantityException extends RuntimeException
{
    public InvalidQuantityException(String msg)
    {
        super(msg);
    }
}
