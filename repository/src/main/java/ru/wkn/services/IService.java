package ru.wkn.services;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * The interface {@code IService} represents a repository service layer.
 *
 * @param <V> the domain type the repository manages
 * @param <I> the type of the id of the entity the repository manages
 * @author Orin Adraas
 */
public interface IService<V, I> {

    /**
     * The method for the {@code PagingAndSortingRepository} instance obtaining.
     *
     * @return the {@code PagingAndSortingRepository} object
     */
    PagingAndSortingRepository<V, I> getRepository();
}
