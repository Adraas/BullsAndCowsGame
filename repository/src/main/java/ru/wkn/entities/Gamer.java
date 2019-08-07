package ru.wkn.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The class {@code Gamer} represents a data of a real-world gamer person.
 *
 * @author Orin Adraas
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "gamer")
public class Gamer {

    /**
     * The ID of a real-world gamer person.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    /**
     * The gamer of a real-world gamer person for a game process related with a him account.
     */
    @Column(unique = true, nullable = false, updatable = false, length = 80)
    private String nickname;

    /**
     * The email of a real-world gamer person for a him account.
     */
    @Column(unique = true, nullable = false, updatable = false, length = 100)
    private String email;

    /**
     * The password of a real-world gamer person for a him account.
     */
    @Column(nullable = false, updatable = false, length = 100)
    private String password;

    /**
     * Initializes a newly created {@code Gamer} object with the given parameter values.
     *
     * @param nickname {@link #nickname}
     * @param email    {@link #email}
     * @param password {@link #password}
     */
    public Gamer(String nickname, String email, String password) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }
}
