package io.github.alaugks.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import io.github.alaugks.spring.messagesource.xliff.catalog.CatalogCache;
import java.util.List;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

    public static final String CACHEABLE_XLIFF_CACHE_NAME = "cacheable-xliff-cache-name";

    @Bean
    public Caffeine<Object, Object> caffeineConfig() {
        // https://stackoverflow.com/a/59898158/22096771
        return Caffeine.newBuilder();
    }

    @Bean
    public CacheManager cacheManager(Caffeine<Object, Object> caffeine) {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
        caffeineCacheManager.setCaffeine(caffeine);
        caffeineCacheManager.setCacheNames(List.of(
            CatalogCache.CACHE_NAME,
            CACHEABLE_XLIFF_CACHE_NAME)
        );
        return caffeineCacheManager;
    }
}
