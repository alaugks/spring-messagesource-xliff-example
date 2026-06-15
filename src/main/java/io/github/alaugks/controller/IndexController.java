package io.github.alaugks.controller;

import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
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


		Date expiryDate = Date.from(
			LocalDate.of(2026, 7, 31)
				.atStartOfDay(ZoneId.of("UTC"))
				.toInstant()
		);

		try {
			model.addAttribute("headline", this.messageSource.getMessage("headline", null, locale));
			model.addAttribute("messages_headline", this.messageSource.getMessage("messages.headline", null, locale));
			model.addAttribute("postcode", this.messageSource.getMessage("postcode", null, locale));
			model.addAttribute("messages_postcode", this.messageSource.getMessage("messages.postcode", null, locale));
			model.addAttribute("payment_headline", this.messageSource.getMessage("payment.headline", null, locale));
			model.addAttribute("payment_expiry_date", this.messageSource.getMessage("payment.expiry-date", null, locale));
			model.addAttribute("expiryDate", expiryDate);
			model.addAttribute("payment_expiry_info", this.messageSource.getMessage(
				"payment.expiry-info",
				new Object[]{Map.of("expiryDate", expiryDate)},
				locale
			));
			model.addAttribute("pgs_file_deleted", this.messageSource.getMessage(
				"pgs.file_deleted",
				new Object[]{Map.of("count", 1000)},
				locale
			));
			model.addAttribute("messages_salutation", this.messageSource.getMessage(
				"messages.salutation",
				new Object[]{Map.of("salutation", 3)},
				locale
			));
			model.addAttribute("pgs_device_hint", this.messageSource.getMessage(
				"pgs.device_hint",
				new Object[]{Map.of("device", "mobile")},
				locale
			));
			model.addAttribute("pgs_greeting", this.messageSource.getMessage(
				"pgs.greeting",
				new Object[]{Map.of("recipient_gender", "feminine")},
				locale
			));
		}
		catch (NoSuchMessageException ignored) {}

		return "home/index";
	}
}
