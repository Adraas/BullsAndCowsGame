package ru.wkn.core.gamealgorithms;

import ru.wkn.core.gameentities.GameAttempt;

/**
 * The interface {@code IResultChecker} represents the abstract result checker for a data obtained from general
 * algorithms.
 *
 * @author Orin Adraas
 */
public interface IResultChecker {

    /**
     * The method for the grading a data obtained from general algorithms.
     *
     * @param gameAttempt the answer of the general algorithms of the game
     * @return {@code true} if the game over, else - {@code false}
     */
    boolean gradeResult(GameAttempt gameAttempt);
}
