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

@Service(value = "gameService")
public class GameService implements IService {

    @Qualifier(value = "gameRepository")
    private GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public void registryNewGame(Game game) {
        gameRepository.save(game);
    }

    public Set<Game> searchGamesByGamer(Gamer gamer) {
        return (Set<Game>) gameRepository.findGamesByGamer(gamer);
    }

    public List<Game> getAllGamesStatistic() {
        List<Game> gamesStatistic = (List<Game>) gameRepository.findAll();
        return gamesStatistic
                .stream()
                .sorted((game1, game2) -> Integer.compare(game2.getAttemptsNumber(), game1.getAttemptsNumber()))
                .collect(Collectors.toList());
    }
}
