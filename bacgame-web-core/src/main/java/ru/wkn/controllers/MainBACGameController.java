package ru.wkn.controllers;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.wkn.RepositoryFacade;
import ru.wkn.controllers.util.ImmutablePair;
import ru.wkn.core.BACGameFacade;
import ru.wkn.core.gamealgorithms.AlgorithmType;
import ru.wkn.core.gameentities.GameAttempt;
import ru.wkn.core.gameexceptions.InputNumbersLineFormatException;
import ru.wkn.core.gameexceptions.NumbersLineLengthException;
import ru.wkn.entities.Game;
import ru.wkn.entities.Gamer;
import ru.wkn.services.GameService;
import ru.wkn.services.GamerService;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainBACGameController {

    private RepositoryFacade repositoryFacade;
    private static Map<String, ImmutablePair<BACGameFacade, Integer>> attempts = new HashMap<>();

    @RequestMapping(path = {"/bacgame_gamer*"}, method = {RequestMethod.GET})
    @ResponseBody
    public JSONObject getGamerName(@RequestHeader(name = "Cookie") String cookie) {
        repositoryFacade = new RepositoryFacade("gamerService");
        Gamer gamer = getGamerByCookie(cookie);
        JSONObject jsonObject = new JSONObject();
        return jsonObject.putOnce("nickname", gamer.getNickname());
    }

    @RequestMapping(path = {"/bacgame_statistics"}, method = {RequestMethod.GET})
    @ResponseBody
    public JSONObject getGameStatistics() {
        repositoryFacade = new RepositoryFacade("gameService");
        List<Game> gameStatistics = ((GameService) repositoryFacade.getService()).getAllGamesStatistic();
        JSONObject jsonObject = new JSONObject();
        for (Game game : gameStatistics) {
            jsonObject.append("attempts", game.getAttemptsNumber());
            jsonObject.append("gamers", game.getGamer().getNickname());
        }
        return jsonObject;
    }

    @RequestMapping(path = {"/bacgame_attempting"}, method = {RequestMethod.POST}, produces = {"application/json"})
    @ResponseBody
    public JSONObject getGameAttemptingResult(@RequestHeader(name = "Cookie") String cookie,
                                              @RequestBody JSONObject inputJsonObject) {
        String numbersLine = (String) inputJsonObject.get("numbersLine");
        try {
            Gamer gamer = getGamerByCookie(cookie);
            BACGameFacade bacGameFacade;
            if (!attempts.containsKey(gamer.getNickname())) {
                bacGameFacade =
                        new BACGameFacade(AlgorithmType.SIMPLE, "simpleGameAttemptResultChecker", (byte) numbersLine.length());
                attempts.put(gamer.getNickname(), new ImmutablePair<>(bacGameFacade, 0));
            }
            bacGameFacade = attempts.get(gamer.getNickname()).getFField();
            GameAttempt gameAttempt = bacGameFacade.getGameAlgorithms().calculate(numbersLine);
            ImmutablePair<BACGameFacade, Integer> immutablePair = attempts.get(gamer.getNickname());
            immutablePair.setSField(immutablePair.getSField() + 1);
            attempts.replace(gamer.getNickname(), immutablePair);
            boolean gameIsOver = bacGameFacade.getResultChecker().gradeResult(gameAttempt);
            JSONObject resultJsonObject = new JSONObject();
            resultJsonObject.put("gameIsOver", gameIsOver);
            if (gameIsOver) {
                repositoryFacade = new RepositoryFacade("gameService");
                repositoryFacade.getService().getRepository()
                        .save(new Game(gamer, attempts.get(gamer.getNickname()).getSField()));
                attempts.remove(gamer.getNickname());
            }
            resultJsonObject.put("resultNumbersLine", gameAttempt.getInputNumbersLine());
            resultJsonObject.put("bacResult", gameAttempt.getResultLine());
            resultJsonObject.put("err", false);
            return resultJsonObject;
        } catch (NumbersLineLengthException | InputNumbersLineFormatException e) {
            e.printStackTrace();
            return new JSONObject().put("err", e);
        }
    }

    private Gamer getGamerByCookie(String cookie) {
        repositoryFacade = new RepositoryFacade("gamerService");
        String[] loginAndPassword = new String(Base64.getDecoder().decode(cookie)).split("&&");
        return ((GamerService) repositoryFacade.getService())
                .authenticate(loginAndPassword[0], loginAndPassword[1]);
    }
}
