package w2;

public class OverdraftBalanceException extends RuntimeException {

//----------------------------------------------------------------------------------------------------------------------

    public OverdraftBalanceException() {

    }

    public OverdraftBalanceException(String s) {
        super(s);
    }

}
