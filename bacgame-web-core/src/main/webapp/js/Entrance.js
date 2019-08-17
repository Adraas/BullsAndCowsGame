class Entrance {

    static signUp(nicknameElement, loginElement, passwordElement) {
        let nickname = document.getElementById(nicknameElement);
        let login = document.getElementById(loginElement);
        let password = document.getElementById(passwordElement);
        let data = "nickname=" + nickname.value + "&login=" + login.value + "&password=" + password.value;
        Entrance.doRequest(data, null, "/bacgame_sign_up", "POST");
    }

    static doRequest(data, header, URL, requestType) {
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
            xmlHttp.send(data);
        } else {
            xmlHttp.setRequestHeader(header, data);
            xmlHttp.send();
        }
    }
}