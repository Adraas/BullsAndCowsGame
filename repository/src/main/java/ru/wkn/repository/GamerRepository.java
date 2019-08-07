package ru.wkn.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.wkn.entities.Gamer;

public interface GamerRepository extends PagingAndSortingRepository<Gamer, Long> {

    Gamer findByEmailAndPassword(String email, String password);
}
