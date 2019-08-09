package ru.wkn.core.gameexceptions;

public class InputLineFormatBACGameException extends BACGameException {

    public InputLineFormatBACGameException(String inputLine) {
        super("the input line '"
                .concat(inputLine)
                .concat("' format wrong; expected only numbers from the interval [0;9] without duplicates"));
    }
}
