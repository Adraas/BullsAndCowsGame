package ru.wkn.core.gamealgorithms;

import lombok.Getter;
import lombok.Setter;
import ru.wkn.core.gameentities.BACGameAttempt;
import ru.wkn.core.gameexceptions.NumbersLineLengthBACGameException;

import java.util.Random;

@Getter
@Setter
public class BACGameAlgorithms {

    private byte numbersLineLength;

    public BACGameAlgorithms(byte numbersLineLength) throws NumbersLineLengthBACGameException {
        if (numbersLineLength < 0 || numbersLineLength > 9) {
            throw new NumbersLineLengthBACGameException(numbersLineLength);
        }
        this.numbersLineLength = numbersLineLength;
    }

    public BACGameAttempt calculate(String inputNumbersLine, String hiddenNumbersLine) {
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
