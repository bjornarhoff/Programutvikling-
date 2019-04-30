package Exceptions;

public class CustomerWrongNumberFromat extends CustomerMustBeIntException {

    public CustomerWrongNumberFromat(String msg) {
        super(msg);
    }
}
