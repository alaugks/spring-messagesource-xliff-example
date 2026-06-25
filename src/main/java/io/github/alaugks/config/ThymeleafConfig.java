package io.github.alaugks.config;

import io.github.alaugks.thymeleaf.LanguageMenuPath;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration
public class ThymeleafConfig {

	@Bean
    public ThymeleafViewResolver thymeleafViewResolver(
        SpringTemplateEngine templateEngine,
        HttpServletRequest request
    ) {
        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
        thymeleafViewResolver.setTemplateEngine(templateEngine);
        thymeleafViewResolver.addStaticVariable("languageMenuPath", new LanguageMenuPath(request));
        return thymeleafViewResolver;
    }
}
