package ru.wkn.core.gamealgorithms;

import ru.wkn.core.gameentities.GameAttempt;

/**
 * The class {@code GameAttemptResultChecker} represents the result checker implementation for a data obtained from
 * general algorithms.
 *
 * @author Orin Adraas
 * @see IResultChecker
 */
public class GameAttemptResultChecker implements IResultChecker {

    /**
     * @see IResultChecker#gradeResult(GameAttempt)
     */
    @Override
    public boolean gradeResult(GameAttempt gameAttempt) {
        byte numbersLineLength = (byte) gameAttempt.getInputNumbersLine().length();
        return gameAttempt.getResultLine().startsWith(String.valueOf(numbersLineLength))
                && gameAttempt.getResultLine().contains(String.valueOf(0));
    }
}
