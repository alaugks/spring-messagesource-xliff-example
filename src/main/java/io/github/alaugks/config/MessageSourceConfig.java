package io.github.alaugks.config;

import io.github.alaugks.spring.messagesource.catalog.resources.LocationPattern;
import io.github.alaugks.spring.messagesource.xliff.XliffResourceMessageSource.Builder;
import java.util.Locale;

import io.github.alaugks.spring.messagesource.xliff.XliffResourceMessageSource;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class MessageSourceConfig {

	public Builder createXliffResourceMessageSourceBuilder() {
		return XliffResourceMessageSource
			.builder(
				Locale.forLanguageTag("en"),
				new LocationPattern("translations/*")
			);
	}

	@Bean(name = "messageSource")
	@Profile("dev")
	public MessageSource messageSourceDev() {
		return this.createXliffResourceMessageSourceBuilder()
			.validateSchema(true)
			.build();
	}

	@Bean
	@Profile("!dev")
	public MessageSource messageSource() {
		return this.createXliffResourceMessageSourceBuilder()
			.build();
	}
}
