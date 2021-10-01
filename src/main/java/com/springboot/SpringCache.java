package com.springboot;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
public class SpringCache {
    public static final String bizCache_10_sec = "bizCache_10_sec";
    public static final String bizCache_30_sec = "bizCache_30_sec";
    public static final String bizCache_60_sec = "bizCache_60_sec";
    public static final String bizCache_300_sec = "bizCache_300_sec";
    public static final String bizCache_600_sec = "bizCache_600_sec";
    public static final String bizCache_1800_sec = "bizCache_1800_sec";
    public static final String bizCache_3600_sec = "bizCache_3600_sec";

    /**
     * 实例本地缓存
     *
     * @return
     */
    @Bean(value = "test111")
    public CacheManager caffeineCacheManager() {
        SimpleCacheManager manager = new SimpleCacheManager();
        List<CaffeineCache> caches = Arrays.asList(
                new CaffeineCache(bizCache_10_sec, Caffeine.newBuilder().recordStats().expireAfterWrite(10, TimeUnit.SECONDS).maximumSize(100000).build()),
                new CaffeineCache(bizCache_30_sec, Caffeine.newBuilder().recordStats().expireAfterWrite(30, TimeUnit.SECONDS).maximumSize(100000).build()),
                new CaffeineCache(bizCache_60_sec, Caffeine.newBuilder().recordStats().expireAfterWrite(60, TimeUnit.SECONDS).maximumSize(100000).build()),
                new CaffeineCache(bizCache_300_sec, Caffeine.newBuilder().recordStats().expireAfterWrite(300, TimeUnit.SECONDS).maximumSize(100000).build()),
                new CaffeineCache(bizCache_600_sec, Caffeine.newBuilder().recordStats().expireAfterWrite(600, TimeUnit.SECONDS).maximumSize(100000).build()),
                new CaffeineCache(bizCache_1800_sec, Caffeine.newBuilder().recordStats().expireAfterWrite(1800, TimeUnit.SECONDS).maximumSize(100000).build()),
                new CaffeineCache(bizCache_3600_sec, Caffeine.newBuilder().recordStats().expireAfterWrite(3600, TimeUnit.SECONDS).maximumSize(100000).build()));
        manager.setCaches(caches);
        return manager;
    }

    @Cacheable(value = bizCache_30_sec, cacheManager = "test111", keyGenerator = "getKey")
    public String testCache() {
        System.out.println("execmethod = 11111111111111" );
        return LocalDateTime.now().toString();
    }
    /**
     * 本地缓存自动生成key
     *
     * @return
     */
    @Bean
    public KeyGenerator getKey() {
        return (target, method, params) -> {
                return "testaa";
        };
    }

}
