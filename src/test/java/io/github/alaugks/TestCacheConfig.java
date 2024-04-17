package io.github.alaugks;

import io.github.alaugks.config.CacheConfig;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;

@EnableCaching
@TestConfiguration
public class TestCacheConfig {

    @Bean("testCacheManager")
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager(CacheConfig.XLIFF_CACHE_NAME, CacheConfig.CACHEABLE_XLIFF_CACHE_NAME);
    }
}
