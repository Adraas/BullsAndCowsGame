package ru.wkn.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.wkn.entities.Game;
import ru.wkn.entities.Gamer;

import java.util.Collection;

public interface GameRepository extends PagingAndSortingRepository<Game, Long> {

    Collection<Game> findGamesByGamer(Gamer gamer);
}
