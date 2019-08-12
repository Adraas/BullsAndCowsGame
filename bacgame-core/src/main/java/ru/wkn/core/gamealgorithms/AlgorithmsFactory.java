package ru.wkn.core.gamealgorithms;

import ru.wkn.core.gameexceptions.NumbersLineLengthException;

/**
 * The class {@code AlgorithmsFactory} represents game algorithms objects factory implementation.
 *
 * @author Orin Adraas
 * @see IAlgorithmsFactory
 */
public class AlgorithmsFactory implements IAlgorithmsFactory {

    /**
     * @see IAlgorithmsFactory#createGameAlgorithms(AlgorithmType, byte)
     */
    @Override
    public IGameAlgorithms createGameAlgorithms(AlgorithmType algorithmType, byte inputNumbersLineLength)
            throws NumbersLineLengthException {
        return algorithmType.equals(AlgorithmType.SIMPLE) ? new GameAlgorithms(inputNumbersLineLength)
                : null;
    }
}
