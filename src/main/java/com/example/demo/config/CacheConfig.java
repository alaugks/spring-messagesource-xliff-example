package com.example.demo.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import io.github.alaugks.spring.messagesource.xliff.catalog.CatalogCache;
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

    /*
    @Bean
    public CacheManager cacheManager() {
        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager();
        cacheManager.setCacheNames(List.of(CatalogCache.CACHE_NAME));
        return cacheManager;
    }
    */

    @Bean
    public Caffeine<Object, Object> caffeineConfig() {
        // https://stackoverflow.com/questions/59396684/how-to-create-caffeine-cache-that-has-no-max-value-and-does-not-expire
        return Caffeine.newBuilder();
    }

    @Bean
    public CacheManager cacheManager(Caffeine<Object, Object> caffeine) {
        Collection<String> cacheNames = List.of(CatalogCache.CACHE_NAME);
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
        caffeineCacheManager.setCaffeine(caffeine);
        caffeineCacheManager.setCacheNames(cacheNames);
        return caffeineCacheManager;
    }
}
