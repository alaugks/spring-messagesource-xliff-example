package io.github.alaugks.config;

import io.github.alaugks.thymeleaf.LanguageMenuPath;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThymeleafConfig {

	@Bean
    public ThymeleafViewResolver thymeleafViewResolver(@Autowired SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
        thymeleafViewResolver.setTemplateEngine(templateEngine);
        thymeleafViewResolver.addStaticVariable("languageMenuPath", LanguageMenuPath.getInstance());
        return thymeleafViewResolver;
    }
}
