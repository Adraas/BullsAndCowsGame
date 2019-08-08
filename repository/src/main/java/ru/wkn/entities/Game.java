package ru.wkn.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

/**
 * The class {@code Game} represents results of a completed game.
 *
 * @author Orin Adraas
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "game")
public class Game implements Serializable {

    /**
     * The ID of a completed game.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * The real-world gamer representation who owns the results. The representation mapped by means the {@code nickname}
     * column from the {@code Gamer} entity.
     */
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "nickname", referencedColumnName = "nickname", unique = true, nullable = false, updatable = false)
    private Gamer gamer;

    /**
     * The number of attempts of a completed game.
     */
    @Column(name = "attempts_number", nullable = false)
    private int attemptsNumber;

    /**
     * Initializes a newly created {@code Game} object with the given parameter values.
     *
     * @param gamer          {@link #gamer}
     * @param attemptsNumber {@link #attemptsNumber}
     */
    public Game(Gamer gamer, int attemptsNumber) {
        this.gamer = gamer;
        this.attemptsNumber = attemptsNumber;
    }
}
