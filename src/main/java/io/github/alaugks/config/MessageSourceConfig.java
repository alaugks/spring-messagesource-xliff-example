package io.github.alaugks.config;

import io.github.alaugks.spring.messagesource.xliff.XliffResourceMessageSource;
import io.github.alaugks.spring.messagesource.xliff.XliffResourceMessageSource.Builder;
import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class MessageSourceConfig {

	@Bean
	public Builder xliffResourceMessageSourceBilder() {
		return XliffResourceMessageSource
			.builder(
				Locale.forLanguageTag("en"),
				"translations/*"
			)
			.enableICU4j(); // Enable for XLIFF 2.2 for PGS Module
	}

	/**
	 * Not DEV and TEST without schema validation
	 */
	@Bean
	@Profile("!dev & !test")
	public MessageSource messageSource(Builder xliffResourceMessageSourceBilder) {
		return xliffResourceMessageSourceBilder
			.build();
	}

	/**
	 * DEV or TEST with schema validation
	 */
	@Bean(name = "messageSource")
	@Profile({"dev", "test"})
	public MessageSource messageSourceWithSchemaValidation(Builder xliffResourceMessageSourceBilder) {
		return xliffResourceMessageSourceBilder
			.enableSchemaValidation()
			.build();
	}
}
