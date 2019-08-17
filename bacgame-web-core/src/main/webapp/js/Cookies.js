class Cookies {

    static getCookie(document, name) {
        let matches = document.cookie.match(new RegExp(
            "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
        ));
        return matches ? decodeURIComponent(matches[1]) : undefined;
    }

    static setCookie(document, name, value) {
        let updatedCookie = name + "=" + value;
        document.cookie = updatedCookie;
    }
}