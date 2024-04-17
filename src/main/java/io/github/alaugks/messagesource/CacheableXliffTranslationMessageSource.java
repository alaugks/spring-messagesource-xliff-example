package io.github.alaugks.messagesource;

import io.github.alaugks.config.CacheConfig;
import java.util.Locale;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;

public class CacheableXliffTranslationMessageSource implements MessageSource {

    private final MessageSource messageSource;

    public CacheableXliffTranslationMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    @Cacheable(CacheConfig.CACHEABLE_XLIFF_CACHE_NAME)
    public String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
        return this.messageSource.getMessage(code, args, defaultMessage, locale);
    }

    @Override
    @Cacheable(CacheConfig.CACHEABLE_XLIFF_CACHE_NAME)
    public String getMessage(String code, Object[] args, Locale locale) throws NoSuchMessageException {
        return this.messageSource.getMessage(code, args, locale);
    }

    @Override
    @Cacheable(CacheConfig.CACHEABLE_XLIFF_CACHE_NAME)
    public String getMessage(MessageSourceResolvable resolvable, Locale locale) throws NoSuchMessageException {
        return this.messageSource.getMessage(resolvable, locale);
    }
}
