package ru.wkn.core.gamealgorithms;

import lombok.Getter;
import lombok.Setter;
import ru.wkn.core.gameentities.GameAttempt;
import ru.wkn.core.gameexceptions.NumbersLineLengthException;

import java.util.Random;

@Getter
@Setter
public class GameAlgorithms {

    private byte numbersLineLength;

    public GameAlgorithms(byte numbersLineLength) throws NumbersLineLengthException {
        if (numbersLineLength < 0 || numbersLineLength > 9) {
            throw new NumbersLineLengthException(numbersLineLength);
        }
        this.numbersLineLength = numbersLineLength;
    }

    public GameAttempt calculate(String inputNumbersLine, String hiddenNumbersLine) {
        return null;
    }

    public String generateRandomValue() {
        String resultRandomValue = "";
        Random random = new Random();
        for (int i = 0; i < numbersLineLength; i++) {
            resultRandomValue = resultRandomValue.concat(String.valueOf(random.nextInt(10)));
        }
        return resultRandomValue;
    }
}
