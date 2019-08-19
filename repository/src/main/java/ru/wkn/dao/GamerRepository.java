package ru.wkn.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.wkn.entities.Gamer;

/**
 * The interface {@code GamerRepository} represents an abstract repository with the specific Spring Data JPA style.
 * This interface provides customized functional for a work with a datasource of {@code Gamer} type entities. It's the
 * DAO layer of the repository.
 *
 * @author Orin Adraas
 */
public interface GamerRepository extends PagingAndSortingRepository<Gamer, Long> {

    /**
     * The method for the finding gamer ({@code Gamer} type) by the given email and password (authentication process).
     *
     * @param email    the given email of a gamer account
     * @param password the given password of a gamer account
     * @return a found gamer data as a {@code Gamer} object
     */
    Gamer findByEmailAndPassword(String email, String password);
}
