class BACGame {

    static xmlHttp = new XMLHttpRequest();
    static numbersLine = [[], []];

    static updateGamerName() {
        BACGame.xmlHttp.open("GET", "/bacgame_gamer", true);
        BACGame.xmlHttp.setRequestHeader("Cookie", Cookies.getCookie(window.document, "bac-gamer"));
        BACGame.xmlHttp.onload = function () {
            let json = JSON.parse(BACGame.xmlHttp.responseText);
            window.document.getElementById("gamer-name").textContent = json.gamerName;
        };
        BACGame.xmlHttp.send();
    }

    static obtainStatistics() {
        BACGame.xmlHttp.open("GET", "/bacgame_statistics", true);
        BACGame.xmlHttp.onload = function () {
            let json = JSON.parse(BACGame.xmlHttp.responseText);
            let gamers = json.gamers;
            let attempts = json.attempts;
            let dataTable = "<table><tr><th>Имя игрока</th><th>Среднее количество попыток<br>на игру</th></tr>";
            for (let i = 0; i < gamers.length; i++) {
                dataTable += "<tr><td>" + gamers[i] + "</td><td>" + attempts[i] + "</td></tr>"
            }
            dataTable += "</table>";
            window.document.getElementById("table-container")
                .appendChild(new DOMParser().parseFromString(dataTable, "text/html"));
        };
        BACGame.xmlHttp.send();
    }

    static updateLogArea() {
        BACGame.xmlHttp.open("POST", "/bacgame_attempting", true);
        BACGame.xmlHttp.overrideMimeType("application/json");
        let numbersLine = "";
        for (let i = 0; i < BACGame.numbersLine.length; i++) {
            let currentLength = BACGame.numbersLine[i].length;
            numbersLine += BACGame.numbersLine[i][currentLength - 1];
        }
        BACGame.xmlHttp.onload = function () {
            let json = JSON.parse(BACGame.xmlHttp.responseText);
            if (json.err === "true") {
                alert(json.err);
            } else {
                let logArea = window.document.getElementById("log-area");
                let bacResult = json.bacResult;
                logArea.value = logArea.value + "\n" + bacResult;
                if (json.gameIsOver === true) {
                    alert("Игра окончена!" + "Результат: " + json.resultNumbersLine + " -> " + bacResult);
                    BACGame.updateSelectors(0);
                    BACGame.numbersLine = [[], []];
                    window.location = "#";
                }
            }
        };
        BACGame.xmlHttp.send(JSON.stringify({"numbersLine": numbersLine}));
    }

    static updateSelectors(selectedValue) {
        BACGame.numbersLine = [];
        let numberSelectorsDiv = window.document.getElementById("number-selectors");
        let numberSelectors = numberSelectorsDiv.childNodes;
        for (let j = 0; j < numberSelectors.length; j++) {
            window.document.removeChild(numberSelectors.item(j));
        }
        let parser = new DOMParser();
        for (let j = 0; j < selectedValue; j++) {
            let selector = "<label><select id='number" + j + "'>" +
                "<option>0</option>" +
                "<option>1</option>" +
                "<option>2</option>" +
                "<option>3</option>" +
                "<option>4</option>" +
                "<option>5</option>" +
                "<option>6</option>" +
                "<option>7</option>" +
                "<option>8</option>" +
                "<option>9</option>" +
                "</select></label>";
            numberSelectorsDiv.appendChild(parser.parseFromString(selector, "text/html"));
            BACGame.updateNumbersLine(0, j);
        }
        window.location = "#new-game-mask";
    }

    static updateNumbersLine(selectedValue, selectorNumber) {
        BACGame.numbersLine[selectorNumber].push(selectedValue);
    }
}