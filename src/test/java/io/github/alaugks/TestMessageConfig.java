package io.github.alaugks;

import io.github.alaugks.messagesource.CacheableXliffTranslationMessageSource;
import io.github.alaugks.spring.messagesource.xliff.XliffTranslationMessageSource;
import java.util.Locale;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestMessageConfig {

    private final Locale defaultLocale = Locale.forLanguageTag("en");

    @Bean("testMessageSource")
    public MessageSource messageSource(CacheManager testCacheManager) {
        XliffTranslationMessageSource messageSource = new XliffTranslationMessageSource(testCacheManager);
        messageSource.setDefaultLocale(defaultLocale);
        messageSource.setBasenamePattern("translations/*");
        return new CacheableXliffTranslationMessageSource(messageSource);
    }
}
