package io.github.alaugks.config;

import java.util.List;
import java.util.Locale;

import io.github.alaugks.spring.requesturilocaleinterceptor.RequestURILocaleInterceptor;
import io.github.alaugks.spring.requesturilocaleinterceptor.RequestURILocaleResolver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfigurerConfig implements WebMvcConfigurer {

	private final Locale defaultLocale = Locale.forLanguageTag("en");

	private final List<Locale> supportedLocales = List.of(
			Locale.forLanguageTag("en"),
			Locale.forLanguageTag("de"),
			Locale.forLanguageTag("en-US")
	);

	@Bean
	public LocaleResolver localeResolver() {
		RequestURILocaleResolver resolver = new RequestURILocaleResolver();
		resolver.setDefaultLocale(this.defaultLocale);
		return resolver;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		RequestURILocaleInterceptor urlInterceptor = RequestURILocaleInterceptor
				.builder(this.defaultLocale)
				.supportedLocales(this.supportedLocales)
				.defaultRequestURI("/en/home")
				.build();

		registry.addInterceptor(urlInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/static/**", "/error");
	}
}
