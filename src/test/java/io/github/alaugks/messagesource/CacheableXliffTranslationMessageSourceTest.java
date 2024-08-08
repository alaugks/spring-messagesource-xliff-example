package io.github.alaugks.messagesource;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import io.github.alaugks.TestCacheConfig;
import io.github.alaugks.TestMessageConfig;
import io.github.alaugks.XliffMessageSourceExampleApplicationTests;
import io.github.alaugks.config.CacheConfig;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = XliffMessageSourceExampleApplicationTests.class)
@Import({TestCacheConfig.class, TestMessageConfig.class})
class CacheableXliffTranslationMessageSourceTest {

    @Autowired
    CacheManager testCacheManager;

    @Autowired
    MessageSource testMessageSource;

    @Test
    void test_cacheable() {
        assertNull(this.getCacheableItem(new SimpleKey("headline", null, "en")));
        this.testMessageSource.getMessage("headline", null, Locale.forLanguageTag("en"));
        assertEquals("Headline", this.getCacheableItem(new SimpleKey("headline", null, "en")));
    }

    private String getCacheableItem(SimpleKey simpleKey) {
        Cache cache = testCacheManager.getCache(CacheConfig.CACHEABLE_XLIFF_CACHE_NAME);
        Map<String, String> result = new HashMap<>();
        Map<Object, Object> items = new HashMap<>((ConcurrentHashMap<?, ?>) cache.getNativeCache());
        items.forEach((code, value) -> result.putIfAbsent(
            code.toString(),
            value.toString()
        ));

        return result.getOrDefault(simpleKey.toString(), null);
    }
}
