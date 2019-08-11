package ru.wkn.core.gamealgorithms;

import lombok.Getter;
import lombok.Setter;
import ru.wkn.core.gameentities.GameAttempt;
import ru.wkn.core.gameexceptions.InputNumbersLineFormatException;
import ru.wkn.core.gameexceptions.NumbersLineLengthException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * The class {@code GameAlgorithms} represents the general base algorithms of the game core.
 *
 * @author Orin Adraas
 */
@Getter
@Setter
public class GameAlgorithms {

    /**
     * The numbers line length (must be more than or equal 0 and less than or equal 9)
     */
    private byte numbersLineLength;

    /**
     * The hidden by the computer numbers.
     */
    private char[] hiddenNumbers;

    /**
     * Initializes a newly created {@code GameAlgorithms} object with the checking parameter to correct and the
     * generating a new random value for the guessing.
     *
     * @param numbersLineLength {@link #numbersLineLength}
     * @throws NumbersLineLengthException thrown if the numbers line length is incorrect
     */
    public GameAlgorithms(byte numbersLineLength) throws NumbersLineLengthException {
        if (numbersLineLength < 0 || numbersLineLength > 9) {
            throw new NumbersLineLengthException(numbersLineLength);
        }
        this.numbersLineLength = numbersLineLength;
        hiddenNumbers = generateRandomValue();
    }

    /**
     * The method for the calculating answer by the input line.
     *
     * @param inputNumbersLine the input numbers line as a {@code String} object
     * @return a {@code GameAttempt} object with the input data and an answer.
     * @throws InputNumbersLineFormatException thrown if the numbers line format is incorrect.
     */
    public GameAttempt calculate(String inputNumbersLine) throws InputNumbersLineFormatException {
        if (!checkFormat(inputNumbersLine)) {
            throw new InputNumbersLineFormatException(inputNumbersLine);
        }
        char[] inputNumbers = inputNumbersLine.toCharArray();
        if (Arrays.equals(inputNumbers, hiddenNumbers)) {
            return new GameAttempt(inputNumbersLine, String.valueOf(numbersLineLength).concat("B0C"));
        }
        byte bulls = 0;
        List<Byte> equalingIndexes = new ArrayList<>();
        for (byte i = 0; i < numbersLineLength; i++) {
            if (inputNumbers[i] == hiddenNumbers[i]) {
                bulls++;
                equalingIndexes.add(i);
            }
        }
        byte cows = 0;
        String hiddenNumbersLine = new String(hiddenNumbers);
        for (byte i = 0; i < numbersLineLength; i++) {
            if (!equalingIndexes.contains(i) && hiddenNumbersLine.contains(String.valueOf(inputNumbers[i]))) {
                cows++;
            }
        }
        return new GameAttempt(inputNumbersLine,
                String.valueOf(bulls).concat("B").concat(String.valueOf(cows)).concat("C"));
    }

    private boolean checkFormat(String inputLine) {
        Pattern pattern = Pattern.compile("[0-9]{".concat(String.valueOf(numbersLineLength)).concat("}"));
        return pattern.matcher(inputLine).matches();
    }

    private char[] generateRandomValue() {
        char[] resultRandomValues = new char[numbersLineLength];
        Random random = new Random();
        for (int i = 0; i < numbersLineLength; i++) {
            resultRandomValues[i] = String.valueOf(random.nextInt(10)).charAt(0);
        }
        return resultRandomValues;
    }
}
