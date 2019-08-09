package ru.wkn.core.gamealgorithms;

import org.junit.jupiter.api.Test;
import ru.wkn.core.gameexceptions.InputLineFormatBACGameException;
import ru.wkn.core.gameexceptions.NumbersLineLengthBACGameException;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BACGameAlgorithmsTest {

    @Test
    void testCalculatingToCorrectData() throws NumbersLineLengthBACGameException {
        BACGameAlgorithms bacGameAlgorithms = new BACGameAlgorithms((byte) 4);
        String hiddenNumbersLine = "1234";
        assertEquals("4B0C", bacGameAlgorithms.calculate(hiddenNumbersLine, hiddenNumbersLine).getResultLine());
    }

    @Test
    void testCalculatingToIncorrectData() throws NumbersLineLengthBACGameException {
        BACGameAlgorithms bacGameAlgorithms = new BACGameAlgorithms((byte) 4);
        String hiddenNumbersLine = "1234";
        String inputNumbersLine = "1253";
        assertEquals("2B1C", bacGameAlgorithms.calculate(inputNumbersLine, hiddenNumbersLine).getResultLine());
    }

    @Test
    void testCalculatingToIncorrectNumbersLineLength() {
        assertThrows(NumbersLineLengthBACGameException.class, () -> new BACGameAlgorithms((byte) 4));
    }

    @Test
    void testCalculatingToIncorrectInputNumbersLineFormat() {
        assertThrows(InputLineFormatBACGameException.class,
                () -> new BACGameAlgorithms((byte) 4).calculate("hello", "world"));
    }

    @Test
    void testToRandomValueGenerating() throws NumbersLineLengthBACGameException {
        byte numbersLineLength = 4;
        BACGameAlgorithms bacGameAlgorithms = new BACGameAlgorithms(numbersLineLength);
        String hiddenLineFormat = "[0-9]{".concat(String.valueOf(numbersLineLength)).concat("}");
        String hiddenNumbersLine = bacGameAlgorithms.generateRandomValue();
        Pattern pattern = Pattern.compile(hiddenLineFormat);
        assertTrue(pattern.matcher(hiddenNumbersLine).matches());
    }
}
