package io.github.alaugks.controller;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	private final MessageSource messageSource;

	public IndexController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@GetMapping("/")
    public ModelAndView index(HttpServletRequest request) {
		// Fallback. Redirect is by RequestURILocaleInterceptor.
        String langCode = request.getLocale().toString();
        return new ModelAndView("redirect:" + String.format("/%s/home", langCode));
    }

	@GetMapping(value = "/{lang}/home", name = "home_index")
	public String index(Model model, Locale locale,  @PathVariable String lang) {

		try {
			model.addAttribute("headline", this.messageSource.getMessage("headline", null, locale));
			model.addAttribute("messages_headline", this.messageSource.getMessage("messages.headline", null, locale));
			model.addAttribute("postcode", this.messageSource.getMessage("postcode", null, locale));
			model.addAttribute("messages_postcode", this.messageSource.getMessage("messages.postcode", null, locale));
			model.addAttribute("payment_headline", this.messageSource.getMessage("payment.headline", null, locale));
			model.addAttribute("payment_expiry_date", this.messageSource.getMessage("payment.expiry_date", null, locale));
		}
		catch (NoSuchMessageException ignored) {}

		return "home/index";
	}
}
