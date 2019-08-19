package ru.wkn.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.wkn.RepositoryFacade;
import ru.wkn.controllers.json.RegistrationJSONData;
import ru.wkn.entities.Gamer;
import ru.wkn.services.GamerService;

@Controller
public class EntranceBACGameController {

    private RepositoryFacade repositoryFacade;

    public EntranceBACGameController() {
        repositoryFacade = new RepositoryFacade("gamerService");
    }

    @RequestMapping(path = {"/login*"}, method = RequestMethod.GET)
    public String logIn(@RequestParam(name = "login") String login, @RequestParam(name = "password") String password) {
        Gamer gamer = ((GamerService) repositoryFacade.getService()).authenticate(login, password);
        return gamer != null ? "/secured/bacgame" : "/sign_in";
    }

    @RequestMapping(path = {"/bacgame_sign_up*"}, method = RequestMethod.POST, produces = "application/json")
    public String registry(@RequestBody RegistrationJSONData data) {
        Gamer gamer = new Gamer(data.getNickname(), data.getLogin(), data.getPassword());
        return ((GamerService) repositoryFacade.getService()).registryNewGamer(gamer) == null ? "/sign_up" : "/sign_in";
    }
}
