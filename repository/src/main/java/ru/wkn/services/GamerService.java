package ru.wkn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.wkn.entities.Gamer;
import ru.wkn.dao.GamerRepository;

/**
 * The class {@code GamerService} represents a repository service layer implementation.
 *
 * @author Orin Adraas
 * @see IService
 */
@Service(value = "gamerService")
public class GamerService implements IService {

    /**
     * The {@code gamerRepository} bean represented a repository (DAO) layer.
     */
    @Qualifier(value = "gamerRepository")
    private GamerRepository gamerRepository;

    /**
     * Initializes a newly created {@code GamerService} object with the simple assignment value to the
     * {@link #gamerRepository} property.
     *
     * @param gamerRepository {@link #gamerRepository}
     */
    @Autowired
    public GamerService(GamerRepository gamerRepository) {
        this.gamerRepository = gamerRepository;
    }

    /**
     * The method for the registration a given {@code Gamer} object as an entity to the repository.
     *
     * @param gamer the given {@code Gamer} entity for the saving
     */
    public void registryNewGamer(Gamer gamer) {
        gamerRepository.save(gamer);
    }

    /**
     * The method for the authenticate by given email and password.
     *
     * @param email    the given email as a {@code String} object
     * @param password the given password as a {@code String} object
     * @return a {@code Gamer} object (entity) if it exists in a repository
     */
    public Gamer authenticate(String email, String password) {
        return gamerRepository.findByEmailAndPassword(email, password);
    }
}
