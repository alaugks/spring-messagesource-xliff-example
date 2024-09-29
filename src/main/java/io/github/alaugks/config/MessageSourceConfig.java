package io.github.alaugks.config;

import java.util.Locale;

import io.github.alaugks.spring.messagesource.xliff.XliffResourceMessageSource;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageSourceConfig {

	@Bean
	public MessageSource messageSource() {
		return XliffResourceMessageSource
				.builder(Locale.forLanguageTag("en"), "translations/*")
				.build();
	}
}
