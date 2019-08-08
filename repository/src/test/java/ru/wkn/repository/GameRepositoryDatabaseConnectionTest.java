package ru.wkn.repository;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.wkn.entities.Game;
import ru.wkn.entities.Gamer;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameRepositoryDatabaseConnectionTest {

    private static GameRepository gameRepository;
    private static Gamer testingGamer;
    private static ApplicationContext context =
            new ClassPathXmlApplicationContext("/META-INF/applicationContext.xml",
                    GameRepositoryDatabaseConnectionTest.class);

    @BeforeAll
    static void fillRepository() {
        // TODO: change to correct autowiring bean assignment principle
        gameRepository = (GameRepository) context.getBean("gameRepository");
        testingGamer = new Gamer("wizard", "wizard@mail.org", "wisdom");
        Game game = new Game(testingGamer, 6);
        gameRepository.save(game);
    }

    @Test
    void testFindingByGamer() {
        Collection<Game> games = gameRepository.findGamesByGamer(testingGamer);
        assertEquals(1, games.size());
    }

    @AfterAll
    static void clearRepository() {
        Collection<Game> games = (Collection<Game>) gameRepository.findAll();
        for (Game game : games) {
            gameRepository.delete(game);
        }
    }
}
