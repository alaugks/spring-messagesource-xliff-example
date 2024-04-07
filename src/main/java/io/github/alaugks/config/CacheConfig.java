package io.github.alaugks.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.List;

@Configuration
@EnableCaching
class CacheConfig {

    public static final String XLIFF_CACHE_NAME = "my-xliff-cache-key-name";

    @Bean
    public Caffeine<Object, Object> caffeineConfig() {
        // https://stackoverflow.com/a/59898158/22096771
        return Caffeine.newBuilder();
    }

    @Bean
    public CacheManager cacheManager(Caffeine<Object, Object> caffeine) {
        Collection<String> cacheNames = List.of(XLIFF_CACHE_NAME);
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
        caffeineCacheManager.setCaffeine(caffeine);
        caffeineCacheManager.setCacheNames(cacheNames);
        return caffeineCacheManager;
    }
}
