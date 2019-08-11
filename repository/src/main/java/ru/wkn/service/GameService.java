package ru.wkn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.wkn.entities.Game;
import ru.wkn.entities.Gamer;
import ru.wkn.repository.GameRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The class {@code GameService} represents a repository service layer implementation.
 *
 * @author Orin Adraas
 * @see IService
 */
@Service(value = "gameService")
public class GameService implements IService {

    /**
     * The {@code gameRepository} bean represented a repository (DAO) layer.
     */
    @Qualifier(value = "gameRepository")
    private GameRepository gameRepository;

    /**
     * Initializes a newly created {@code GameService} object with the simple assignment value to the
     * {@link #gameRepository} property.
     *
     * @param gameRepository {@link #gameRepository}
     */
    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    /**
     * The method for the registration a given {@code Game} object as an entity to the repository.
     *
     * @param game the given {@code Game} entity for the saving
     */
    public void registryNewGame(Game game) {
        gameRepository.save(game);
    }

    /**
     * The method for the all games searching by the given {@code Gamer} object.
     *
     * @param gamer the given {@code Gamer} object for the searching
     * @return a collection of the found objects
     */
    public Set<Game> searchGamesByGamer(Gamer gamer) {
        return (Set<Game>) gameRepository.findGamesByGamer(gamer);
    }

    /**
     * The method for the all games sorted statistic obtaining.
     *
     * @return a collection of the found objects
     */
    public List<Game> getAllGamesStatistic() {
        List<Game> gamesStatistic = (List<Game>) gameRepository.findAll();
        return gamesStatistic
                .stream()
                .sorted((game1, game2) -> Integer.compare(game2.getAttemptsNumber(), game1.getAttemptsNumber()))
                .collect(Collectors.toList());
    }
}
