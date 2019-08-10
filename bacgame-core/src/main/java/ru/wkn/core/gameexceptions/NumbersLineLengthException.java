package ru.wkn.core.gameexceptions;

public class NumbersLineLengthException extends BACGameException {

    public NumbersLineLengthException(byte numberLength) {
        super("the actual number length: ".concat(String.valueOf(numberLength)).concat("; expected: [0;9]"));
    }
}
