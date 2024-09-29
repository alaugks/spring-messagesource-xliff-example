package io.github.alaugks.thymeleaf;

import java.util.Arrays;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageMenuPath {

    private final HttpServletRequest request;
    private static LanguageMenuPath instance;

    @Autowired
    public LanguageMenuPath(HttpServletRequest request) {
        this.request = request;
        instance = this; //NOSONAR
    }

    public static LanguageMenuPath getInstance() {
        return instance;
    }

    public String get(String locale) {
        String[] uri = request.getRequestURI().trim().replaceAll("^/", "").split("/");
        return joinUriWithoutLang(locale, uri);
    }

    private String joinUriWithoutLang(String locale, String... uri) {
        String joinedUri = String.join(
				"/",
				Arrays.copyOfRange(uri, 1, uri.length)
        );
		return !joinedUri.isEmpty() ? "/" + locale + "/" + joinedUri : "";
    }
}
