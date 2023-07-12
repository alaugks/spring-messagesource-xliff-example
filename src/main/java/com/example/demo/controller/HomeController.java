package com.example.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Locale;

@Controller
@RequestMapping("/{lang}")
public class HomeController {

    private final MessageSource messageSource;
    
    public HomeController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping(value = "/home", name = "home_index")
    public String index() {
        return "home/index";
    }

    @GetMapping(value = "/translations", name = "home_translations")
    public String translations(Model model, HttpServletRequest request, Locale locale) {
        HashMap<String, String> translations = new HashMap<>();

        translations.put("postcode", this.messageSource.getMessage("postcode", null, locale));
        translations.put("messages.postcode", this.messageSource.getMessage("messages.postcode", null, locale));
        translations.put("headline", this.messageSource.getMessage("headline", null, locale));
        translations.put("messages.headline", this.messageSource.getMessage("messages.headline", null, locale));
        translations.put("payment.headline", this.messageSource.getMessage("payment.headline", null, locale));
        translations.put("payment.expiry_date", this.messageSource.getMessage("payment.expiry_date", null, locale));

        model.addAttribute("translations", translations);
        return "home/translations";
    }
}
