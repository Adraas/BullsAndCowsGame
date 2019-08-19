package ru.wkn.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.wkn.entities.Game;
import ru.wkn.entities.Gamer;

import java.util.Collection;

/**
 * The interface {@code GameRepository} represents an abstract repository with the specific Spring Data JPA style.
 * This interface provides customized functional for a work with a datasource of {@code Game} type entities. It's the
 * DAO layer of the repository.
 *
 * @author Orin Adraas
 */
public interface GameRepository extends PagingAndSortingRepository<Game, Long> {

    /**
     * The method for the finding games ({@code Game} type) by the given gamer ({@code Gamer} type) data.
     *
     * @param gamer the given gamer data for the searching
     * @return a collection of found {@code Game} objects
     */
    Collection<Game> findGamesByGamer(Gamer gamer);
}
