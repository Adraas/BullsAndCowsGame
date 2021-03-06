package ru.wkn.core.gamealgorithms;

import org.junit.jupiter.api.Test;
import ru.wkn.core.gameentities.GameAttempt;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameAttemptResultCheckerTest {

    @Test
    void testSimpleResultGradingToTrue() {
        GameAttempt gameAttempt = new GameAttempt("1234", "4B0C");
        IResultChecker gameAttemptResultChecker = new GameAttemptResultChecker();
        assertTrue(gameAttemptResultChecker.gradeResult(gameAttempt));
    }

    @Test
    void testSimpleResultGradingToFalse() {
        GameAttempt gameAttempt = new GameAttempt("1234", "3B0C");
        IResultChecker gameAttemptResultChecker = new GameAttemptResultChecker();
        assertFalse(gameAttemptResultChecker.gradeResult(gameAttempt));
    }
}
