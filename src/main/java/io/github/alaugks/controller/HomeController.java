package io.github.alaugks.controller;

import java.util.LinkedHashMap;
import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String translations(Model model, Locale locale) {
        LinkedHashMap<String, String> translations = new LinkedHashMap<>();

        translations.put("headline", this.messageSource.getMessage("headline", null, locale));
        translations.put("messages.headline", this.messageSource.getMessage("messages.headline", null, locale));
        translations.put("postcode", this.messageSource.getMessage("postcode", null, locale));
        translations.put("messages.postcode", this.messageSource.getMessage("messages.postcode", null, locale));
        translations.put("files-found", this.messageSource.getMessage("files-found", new Object[]{10000L}, locale));
        translations.put("messages.files-found",
            this.messageSource.getMessage("messages.files-found", new Object[]{10000L}, locale));


        translations.put("payment.headline", this.messageSource.getMessage("payment.headline", null, locale));
        translations.put("payment.expiry-date", this.messageSource.getMessage("payment.expiry-date", null, locale));

        // With arguments
        Object[] args = {"john.doe@example.com"};
        translations.put("email-notice", this.messageSource.getMessage("email-notice", args, locale));
        translations.put("messages.email-notice", this.messageSource.getMessage("email-notice", args, locale));

        // Show default message if id not exists
        String defaultMessage = this.messageSource.getMessage("default-message", null, locale);
        translations.put("not-exists-id", this.messageSource.getMessage("not-exists-id", null, defaultMessage, locale));

        model.addAttribute("translations", translations);
        return "home/translations";
    }
}
