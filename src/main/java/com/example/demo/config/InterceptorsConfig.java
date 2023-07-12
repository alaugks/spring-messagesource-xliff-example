package com.example.demo.config;

import com.example.demo.interceptor.UrlLocaleInterceptor;
import com.example.demo.resolver.MinimalCustomLocaleResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.Locale;

@Configuration
public class InterceptorsConfig implements WebMvcConfigurer {
    private final UrlLocaleInterceptor urlInterceptor;
    private final Locale defaultLocale = Locale.forLanguageTag("en");
    private final List<Locale> supportedLocales = List.of(
            Locale.forLanguageTag("en"),
            Locale.forLanguageTag("de"),
            Locale.forLanguageTag("en-US")
    );

    @Autowired
    public InterceptorsConfig(UrlLocaleInterceptor urlInterceptor) {
        this.urlInterceptor = urlInterceptor;
    }

    @Bean
    public LocaleResolver localeResolver() {
        MinimalCustomLocaleResolver resolver = new MinimalCustomLocaleResolver();
        resolver.setDefaultLocale(Locale.forLanguageTag("en"));
        return resolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        this.urlInterceptor.setDefaultLocale(defaultLocale);
        this.urlInterceptor.setSupportedLocales(supportedLocales);
        this.urlInterceptor.setDefaultHomePath(
                String.format(
                        "/%s/home",
                        defaultLocale.toString()
                )
        );
        registry.addInterceptor(this.urlInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/static/**", "/error");
    }
}
