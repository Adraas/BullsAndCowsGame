package ru.wkn.core.gamealgorithms;

import ru.wkn.core.gameentities.GameAttempt;
import ru.wkn.core.gameexceptions.InputNumbersLineFormatException;

/**
 * The interface {@code IGameAlgorithms} represents the abstract general base algorithms of the game core.
 *
 * @author Orin Adraas
 */
public interface IGameAlgorithms {

    /**
     * The method for the calculating answer by the input line.
     *
     * @param inputNumbersLine the input numbers line as a {@code String} object
     * @return a {@code GameAttempt} object with the input data and an answer.
     * @throws InputNumbersLineFormatException thrown if the numbers line format is incorrect.
     */
    GameAttempt calculate(String inputNumbersLine) throws InputNumbersLineFormatException;
}
