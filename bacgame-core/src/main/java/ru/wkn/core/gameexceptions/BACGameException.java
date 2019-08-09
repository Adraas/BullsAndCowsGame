package ru.wkn.core.gameexceptions;

public class BACGameException extends Exception {

    public BACGameException(String message) {
        super("'Bull and cow' game exception cause: ".concat(message));
    }
}
