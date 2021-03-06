package ru.wkn.core.gamealgorithms;

import org.junit.jupiter.api.Test;
import ru.wkn.core.gameexceptions.InputNumbersLineFormatException;
import ru.wkn.core.gameexceptions.NumbersLineLengthException;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameAlgorithmsTest {

    @Test
    void testSimpleCalculatingToCorrectData() throws NumbersLineLengthException, InputNumbersLineFormatException,
            NoSuchFieldException, IllegalAccessException {
        IGameAlgorithms gameAlgorithms = new GameAlgorithms((byte) 4);
        String hiddenNumbersLine = "1234";
        Field field = gameAlgorithms.getClass().getDeclaredField("hiddenNumbers");
        field.setAccessible(true);
        field.set(gameAlgorithms, hiddenNumbersLine.toCharArray());
        assertEquals("4B0C", gameAlgorithms.calculate(hiddenNumbersLine).getResultLine());
    }

    @Test
    void testSimpleCalculatingToIncorrectData() throws NumbersLineLengthException, InputNumbersLineFormatException,
            NoSuchFieldException, IllegalAccessException {
        IGameAlgorithms gameAlgorithms = new GameAlgorithms((byte) 4);
        String inputNumbersLine = "1253";
        Field field = gameAlgorithms.getClass().getDeclaredField("hiddenNumbers");
        field.setAccessible(true);
        field.set(gameAlgorithms, "1234".toCharArray());
        assertEquals("2B1C", gameAlgorithms.calculate(inputNumbersLine).getResultLine());
    }

    @Test
    void testSimpleCalculatingToIncorrectNumbersLineLength() {
        assertThrows(NumbersLineLengthException.class, () -> new GameAlgorithms((byte) 14));
    }

    @Test
    void testSimpleCalculatingToIncorrectInputNumbersLineFormat() {
        assertThrows(InputNumbersLineFormatException.class,
                () -> new GameAlgorithms((byte) 4).calculate("hello world"));
        assertThrows(InputNumbersLineFormatException.class,
                () -> new GameAlgorithms((byte) 4).calculate("1111"));
        assertThrows(InputNumbersLineFormatException.class,
                () -> new GameAlgorithms((byte) 4).calculate("123456"));
    }
}
