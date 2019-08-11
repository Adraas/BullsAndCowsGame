package ru.wkn.core;

import lombok.Getter;
import lombok.Setter;
import ru.wkn.core.gamealgorithms.AlgorithmType;
import ru.wkn.core.gamealgorithms.AlgorithmsFactory;
import ru.wkn.core.gamealgorithms.IAlgorithmsFactory;
import ru.wkn.core.gamealgorithms.IGameAlgorithms;
import ru.wkn.core.gamealgorithms.IResultChecker;
import ru.wkn.core.gamealgorithms.ResultCheckerType;
import ru.wkn.core.gameexceptions.NumbersLineLengthException;

/**
 * The class {@code BACGameFacade} represents the facade of the game core.
 *
 * @author Orin Adraas
 */
@Getter
@Setter
public class BACGameFacade {

    /**
     * The main game core algorithms.
     */
    private IGameAlgorithms gameAlgorithms;

    /**
     * The result checker for the main game core algorithms answers;
     */
    private IResultChecker resultChecker;

    /**
     * Initializes a newly created {@code BACGameFacade} object with the creating factory and the creating by it help
     * general game core algorithm representations.
     *
     * @param algorithmType          the general game core algorithms implementation type
     * @param resultCheckerType      the result checker type
     * @param inputNumbersLineLength the input numbers line length
     * @throws NumbersLineLengthException thrown if the input numbers line length is incorrect
     */
    public BACGameFacade(AlgorithmType algorithmType, ResultCheckerType resultCheckerType, byte inputNumbersLineLength)
            throws NumbersLineLengthException {
        IAlgorithmsFactory algorithmsFactory = new AlgorithmsFactory();
        gameAlgorithms = algorithmsFactory.createGameAlgorithms(algorithmType, inputNumbersLineLength);
        resultChecker = algorithmsFactory.createResultChecker(resultCheckerType);
    }
}
