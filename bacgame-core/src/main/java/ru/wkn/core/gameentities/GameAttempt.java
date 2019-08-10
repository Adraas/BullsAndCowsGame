package ru.wkn.core.gameentities;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The class {@code GameAttempt} represents a game attempt to guess a hidden number and a grade of an attempt.
 *
 * @author Orin Adraas
 */
@AllArgsConstructor
@Getter
public class GameAttempt {

    /**
     * The input guessed numbers as the {@code String} object.
     */
    private String inputNumbersLine;

    /**
     * The grade of an attempt to guess a hidden number.
     */
    private String resultLine;
}
