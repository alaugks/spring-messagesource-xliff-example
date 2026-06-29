package io.github.alaugks.config;

import io.github.alaugks.spring.messagesource.catalog.resources.LocationPattern;
import io.github.alaugks.spring.messagesource.xliff.XliffResourceMessageSource;
import io.github.alaugks.spring.messagesource.xliff.XliffResourceMessageSource.Builder;
import java.util.Locale;
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
			)
			.enableICU4j(); // Enable for XLIFF 2.2 for PGS Module
	}

	@Bean(name = "messageSource")
	@Profile({"dev", "test"})
	public MessageSource messageSourceWithSchemaValidation() {
		return this.createXliffResourceMessageSourceBuilder()
			.validateSchema(true)
			.build();
	}

	@Bean
	@Profile("!dev & !test")
	public MessageSource messageSource() {
		return this.createXliffResourceMessageSourceBuilder()
			.build();
	}
}
