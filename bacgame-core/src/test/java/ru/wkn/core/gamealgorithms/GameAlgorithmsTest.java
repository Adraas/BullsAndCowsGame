package ru.wkn.core.gamealgorithms;

import org.junit.jupiter.api.Test;
import ru.wkn.core.gameexceptions.InputNumbersLineFormatException;
import ru.wkn.core.gameexceptions.NumbersLineLengthException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameAlgorithmsTest {

    @Test
    void testCalculatingToCorrectData() throws NumbersLineLengthException, InputNumbersLineFormatException,
            NoSuchFieldException, IllegalAccessException {
        GameAlgorithms gameAlgorithms = new GameAlgorithms((byte) 4);
        String hiddenNumbersLine = "1234";
        gameAlgorithms.getClass().getField("hiddenNumbersLine").set(gameAlgorithms, hiddenNumbersLine);
        assertEquals("4B0C", gameAlgorithms.calculate(hiddenNumbersLine).getResultLine());
    }

    @Test
    void testCalculatingToIncorrectData() throws NumbersLineLengthException, InputNumbersLineFormatException {
        GameAlgorithms gameAlgorithms = new GameAlgorithms((byte) 4);
        String inputNumbersLine = "1253";
        assertEquals("2B1C", gameAlgorithms.calculate(inputNumbersLine).getResultLine());
    }

    @Test
    void testCalculatingToIncorrectNumbersLineLength() {
        assertThrows(NumbersLineLengthException.class, () -> new GameAlgorithms((byte) 14));
    }

    @Test
    void testCalculatingToIncorrectInputNumbersLineFormat() {
        assertThrows(InputNumbersLineFormatException.class,
                () -> new GameAlgorithms((byte) 4).calculate("hello world"));
    }
}
