package ru.wkn.core.gamealgorithms;

import org.junit.jupiter.api.Test;
import ru.wkn.core.gameentities.BACGameAttempt;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BACGameResultCheckerTest {

    @Test
    void testResultGradingToTrue() {
        BACGameAttempt bacGameAttempt = new BACGameAttempt("1234", "4B0C");
        BACGameResultChecker bacGameResultChecker = new BACGameResultChecker();
        assertTrue(bacGameResultChecker.gradeResult(bacGameAttempt));
    }

    @Test
    void testResultGradingToFalse() {
        BACGameAttempt bacGameAttempt = new BACGameAttempt("1234", "3B0C");
        BACGameResultChecker bacGameResultChecker = new BACGameResultChecker();
        assertFalse(bacGameResultChecker.gradeResult(bacGameAttempt));
    }
}
