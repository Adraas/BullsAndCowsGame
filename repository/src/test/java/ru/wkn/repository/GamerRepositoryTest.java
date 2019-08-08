package ru.wkn.repository;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.wkn.entities.Gamer;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class GamerRepositoryTest {

    @Autowired
    private static GamerRepository gamerRepository;
    private static String testingEmail = "wizard@mail.org";
    private static String testingPassword = "wisdom";

    @BeforeAll
    static void fillRepository() {
        Gamer gamer = new Gamer("wizard", testingEmail, testingPassword);
        gamerRepository.save(gamer);
    }

    @Test
    void testFindingByEmailAndPassword() {
        Gamer gamer = gamerRepository.findByEmailAndPassword(testingEmail, testingPassword);
        assertNotEquals(null, gamer);
    }

    @AfterAll
    static void clearRepository() {
        Collection<Gamer> gamers = (Collection<Gamer>) gamerRepository.findAll();
        for (Gamer gamer : gamers) {
            gamerRepository.delete(gamer);
        }
    }
}
