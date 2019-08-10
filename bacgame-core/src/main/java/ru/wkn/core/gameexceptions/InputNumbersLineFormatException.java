package ru.wkn.core.gameexceptions;

public class InputNumbersLineFormatException extends BACGameException {

    public InputNumbersLineFormatException(String inputLine) {
        super("the input line '"
                .concat(inputLine)
                .concat("' format wrong; expected only numbers from the interval [0;9] without duplicates"));
    }
}
