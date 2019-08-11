package ru.wkn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.wkn.entities.Gamer;
import ru.wkn.repository.GamerRepository;

@Service(value = "gamerService")
public class GamerService implements IService {

    @Qualifier(value = "gamerRepository")
    private GamerRepository gamerRepository;

    @Autowired
    public GamerService(GamerRepository gamerRepository) {
        this.gamerRepository = gamerRepository;
    }

    public void registryNewGamer(Gamer gamer) {
        gamerRepository.save(gamer);
    }

    public Gamer authenticate(String email, String password) {
        return gamerRepository.findByEmailAndPassword(email, password);
    }
}
