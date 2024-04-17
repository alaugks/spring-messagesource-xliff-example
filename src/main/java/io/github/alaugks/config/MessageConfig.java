package io.github.alaugks.config;

import io.github.alaugks.messagesource.CacheableXliffTranslationMessageSource;
import io.github.alaugks.spring.messagesource.xliff.XliffTranslationMessageSource;
import java.util.Locale;
import org.springframework.cache.CacheManager;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {

    private final Locale defaultLocale = Locale.forLanguageTag("en");

    @Bean
    public MessageSource messageSource(CacheManager cacheManager) {
        XliffTranslationMessageSource messageSource = new XliffTranslationMessageSource(cacheManager);
        messageSource.setDefaultLocale(defaultLocale);
        messageSource.setBasenamePattern("translations/*");
        return new CacheableXliffTranslationMessageSource(messageSource);
    }
}
