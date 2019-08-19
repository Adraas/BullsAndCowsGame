package ru.wkn.controllers;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.wkn.RepositoryFacade;
import ru.wkn.entities.Gamer;
import ru.wkn.services.GamerService;

@Controller
public class EntranceBACGameController {

    private RepositoryFacade repositoryFacade;

    public EntranceBACGameController() {
        repositoryFacade = new RepositoryFacade("gamerService");
    }

    @RequestMapping(path = {"/bacgame_sign_up*"}, method = {RequestMethod.POST}, produces = {"application/json"})
    public String registry(@RequestBody JSONObject jsonObject) {
        Gamer gamer = new Gamer(jsonObject.getString("nickname"),
                jsonObject.getString("login"), jsonObject.getString("password"));
        return ((GamerService) repositoryFacade.getService()).registryNewGamer(gamer) == null ? "/sign_up" : "/sign_in";
    }
}
