package ru.wkn.core.gameexceptions;

/**
 * The class {@code NumbersLineLengthException} represents a custom exception indicated that some error or
 * exception related with an obtaining incorrect numbers line length into the game process was thrown.
 *
 * @author Orin Adraas
 */
public class NumbersLineLengthException extends BACGameException {

    /**
     * Constructors a new exception with the specified detail message.
     * @param numbersLineLength the obtained numbers line length
     */
    public NumbersLineLengthException(byte numbersLineLength) {
        super("the actual numbers line length: ".concat(String.valueOf(numbersLineLength)).concat("; expected: [0;9]"));
    }
}
