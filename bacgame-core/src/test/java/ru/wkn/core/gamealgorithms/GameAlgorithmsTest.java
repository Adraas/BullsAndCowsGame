package ru.wkn.core.gamealgorithms;

import org.junit.jupiter.api.Test;
import ru.wkn.core.gameexceptions.InputNumbersLineFormatException;
import ru.wkn.core.gameexceptions.NumbersLineLengthException;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameAlgorithmsTest {

    @Test
    void testCalculatingToCorrectData() throws NumbersLineLengthException, InputNumbersLineFormatException {
        GameAlgorithms gameAlgorithms = new GameAlgorithms((byte) 4);
        String hiddenNumbersLine = "1234";
        assertEquals("4B0C", gameAlgorithms.calculate(hiddenNumbersLine, hiddenNumbersLine).getResultLine());
    }

    @Test
    void testCalculatingToIncorrectData() throws NumbersLineLengthException, InputNumbersLineFormatException {
        GameAlgorithms gameAlgorithms = new GameAlgorithms((byte) 4);
        String hiddenNumbersLine = "1234";
        String inputNumbersLine = "1253";
        assertEquals("2B1C", gameAlgorithms.calculate(inputNumbersLine, hiddenNumbersLine).getResultLine());
    }

    @Test
    void testCalculatingToIncorrectNumbersLineLength() {
        assertThrows(NumbersLineLengthException.class, () -> new GameAlgorithms((byte) 14));
    }

    @Test
    void testCalculatingToIncorrectInputNumbersLineFormat() {
        assertThrows(InputNumbersLineFormatException.class,
                () -> new GameAlgorithms((byte) 4).calculate("hello", "world"));
    }

    @Test
    void testToRandomValueGenerating() throws NumbersLineLengthException {
        byte numbersLineLength = 4;
        GameAlgorithms gameAlgorithms = new GameAlgorithms(numbersLineLength);
        String hiddenLineFormat = "[0-9]{".concat(String.valueOf(numbersLineLength)).concat("}");
        String hiddenNumbersLine = gameAlgorithms.generateRandomValue();
        Pattern pattern = Pattern.compile(hiddenLineFormat);
        assertTrue(pattern.matcher(hiddenNumbersLine).matches());
    }
}
