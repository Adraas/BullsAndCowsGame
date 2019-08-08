package ru.wkn.repository;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.wkn.entities.Gamer;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class GamerRepositoryTest {

    private static GamerRepository gamerRepository;
    private static String testingEmail = "wizard@mail.org";
    private static String testingPassword = "wisdom";
    private static ApplicationContext context =
            new ClassPathXmlApplicationContext("/META-INF/applicationContext.xml",
                    GamerRepositoryTest.class);

    @BeforeAll
    static void fillRepository() {
        // TODO: change to correct autowiring bean assignment principle
        gamerRepository = (GamerRepository) context.getBean("gamerRepository");
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
