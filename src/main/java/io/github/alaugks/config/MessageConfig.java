package io.github.alaugks.config;

import io.github.alaugks.spring.messagesource.xliff.XliffTranslationMessageSource;
import org.springframework.cache.CacheManager;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

@Configuration
public class MessageConfig implements WebMvcConfigurer {
    private final Locale defaultLocale = Locale.forLanguageTag("en");

    @Bean()
    public MessageSource messageSource(CacheManager cacheManager) {
        return XliffTranslationMessageSource
            .builder(cacheManager.getCache(CacheConfig.XLIFF_CACHE_NAME))
            .defaultLocale(defaultLocale)
            .basenamePattern("translations/*")
            .build();
    }
}
