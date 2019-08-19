class Entrance {

    static signUp(nicknameElement, loginElement, passwordElement) {
        let nickname = document.getElementById(nicknameElement).value;
        let login = document.getElementById(loginElement).value;
        let password = document.getElementById(passwordElement).value;
        let jsonData = JSON.stringify({"nickname": nickname, "login": login, "password": password});
        Entrance.doRequest(jsonData, null, "/bacgame_sign_up", "POST");
    }

    static doRequest(jsonData, header, URL, requestType) {
        let xmlHttp = new XMLHttpRequest();
        xmlHttp.onload = function () {
            let response = xmlHttp.responseText;
            if (response.trim() !== "") {
                alert(response);
            }
        };
        xmlHttp.open(requestType, URL, false);
        BACGame.xmlHttp.overrideMimeType("application/json");
        if (header == null) {
            xmlHttp.send(jsonData);
        } else {
            xmlHttp.setRequestHeader(header, jsonData);
            xmlHttp.send();
        }
    }
}