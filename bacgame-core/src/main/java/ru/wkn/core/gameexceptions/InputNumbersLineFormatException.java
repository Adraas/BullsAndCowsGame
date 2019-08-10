package ru.wkn.core.gameexceptions;

/**
 * The class {@code InputNumbersLineFormatException} represents a custom exception indicated that some error or
 * exception related with an input line format into the game process was thrown.
 *
 * @author Orin Adraas
 */
public class InputNumbersLineFormatException extends BACGameException {

    /**
     * Constructors a new exception with the specified detail message.
     *
     * @param inputLine the input numbers line as a {@code String} object
     */
    public InputNumbersLineFormatException(String inputLine) {
        super("the input line '"
                .concat(inputLine)
                .concat("' format wrong; expected only numbers from the interval [0;9] without duplicates"));
    }
}
