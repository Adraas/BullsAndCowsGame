package ru.wkn.core.gameexceptions;

/**
 * The class {@code BACGameException} represents a custom exception indicated that some error or
 * exception into the game process was thrown.
 *
 * @author Orin Adraas
 */
public class BACGameException extends Exception {

    /**
     * @see Exception#Exception(String)
     */
    public BACGameException(String message) {
        super("'Bull and cow' game exception cause: ".concat(message));
    }
}
