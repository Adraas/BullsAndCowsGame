package ru.wkn.authentication.filters;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;

public class CookieFormLoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        String login = request.getParameter("login");
        String encodingLogin = Base64.getEncoder().encodeToString(login.getBytes());
        ((HttpServletResponse) response).addCookie(new Cookie("bac-gamer", encodingLogin));
    }
}
