package com.demo.example.messagesource;

import io.github.alaugks.spring.translation.xliff.XliffCacheableKeyGenerator;
import io.github.alaugks.spring.translation.xliff.XliffTranslationMessageSource;
import io.github.alaugks.spring.translation.xliff.catalog.CatalogCache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.lang.Nullable;

import java.util.Locale;

class CacheableXliffTranslationMessageSource extends XliffTranslationMessageSource {
    public CacheableXliffTranslationMessageSource(CacheManager cacheManager) {
        super(cacheManager);
    }

    @Nullable
    @Cacheable(
            value = CatalogCache.CACHE_NAME,
            keyGenerator = XliffCacheableKeyGenerator.GENERATOR_NAME,
            condition = "#args.length == 0" // Do not cache with replaced args
    )
    @Override
    public String getMessage(String code, @Nullable Object[] args, @Nullable String defaultMessage, Locale locale) {
        return super.getMessage(code, args, defaultMessage, locale);
    }

    @Nullable
    @Cacheable(
            value = CatalogCache.CACHE_NAME,
            keyGenerator = XliffCacheableKeyGenerator.GENERATOR_NAME,
            condition = "#args.length == 0" // Do not cache with replaced args
    )
    @Override
    public String getMessage(String code, Object[] args, Locale locale) throws NoSuchMessageException {
        return super.getMessage(code, args, locale);
    }

    @Cacheable(
            value = CatalogCache.CACHE_NAME,
            keyGenerator = XliffCacheableKeyGenerator.GENERATOR_NAME,
            condition = "#resolvable.getArguments().length == 0" // Do not cache with replaced args
    )
    @Override
    public String getMessage(MessageSourceResolvable resolvable, Locale locale) throws NoSuchMessageException {
        return super.getMessage(resolvable, locale);
    }
}
