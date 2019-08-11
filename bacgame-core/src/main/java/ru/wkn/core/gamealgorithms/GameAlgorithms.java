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

@Getter
@Setter
public class GameAlgorithms {

    private byte numbersLineLength;
    private char[] hiddenNumbers;

    public GameAlgorithms(byte numbersLineLength) throws NumbersLineLengthException {
        if (numbersLineLength < 0 || numbersLineLength > 9) {
            throw new NumbersLineLengthException(numbersLineLength);
        }
        this.numbersLineLength = numbersLineLength;
        hiddenNumbers = generateRandomValue();
    }

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
