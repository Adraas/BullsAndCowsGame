package ru.wkn.core.gamealgorithms;

import ru.wkn.core.gameexceptions.NumbersLineLengthException;

/**
 * The interface {@code IAlgorithmsFactory} represents game algorithms objects abstract factory.
 *
 * @author Orin Adraas
 */
public interface IAlgorithmsFactory {

    /**
     * The method for the {@code IGameAlgorithms} objects creating.
     *
     * @param algorithmType          the general game core algorithms implementation type
     * @param inputNumbersLineLength the input numbers line length
     * @return a newly created {@code IGameAlgorithms} object
     * @throws NumbersLineLengthException thrown if the input numbers line length is incorrect
     */
    IGameAlgorithms createGameAlgorithms(AlgorithmType algorithmType, byte inputNumbersLineLength)
            throws NumbersLineLengthException;
}
