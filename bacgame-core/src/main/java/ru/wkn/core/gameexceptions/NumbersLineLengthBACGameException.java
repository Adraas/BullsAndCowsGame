package ru.wkn.core.gameexceptions;

public class NumbersLineLengthBACGameException extends BACGameException {

    public NumbersLineLengthBACGameException(byte numberLength) {
        super("the actual number length: ".concat(String.valueOf(numberLength)).concat("; expected: [0;9]"));
    }
}
