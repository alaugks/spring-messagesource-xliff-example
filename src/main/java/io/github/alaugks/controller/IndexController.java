package io.github.alaugks.controller;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@GetMapping("/")
    public ModelAndView index(HttpServletRequest request) {
		// Fallback. Redirect is by RequestURILocaleInterceptor.
        String langCode = request.getLocale().toString();
        return new ModelAndView("redirect:" + String.format("/%s/home", langCode));
    }
}
