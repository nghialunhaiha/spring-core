package org.led.simba.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

//@Configuration
/*
 * @EnableCaching
 * 
 * They create an aspect with pointcuts that trigger off of Spring’s caching annotations. Depending on the annotation
 * used and the state of the cache, that aspect will fetch a value from the cache, add a value to the cache, or remove a
 * value from the cache.
 */
@EnableCaching
public class BaseCachingConfig {

    @Bean
    public CacheManager cacheManager() {
        /*
         * In this case, a ConcurrentMapCacheManager is declared.
         * 
         * This simple cache manager uses a java.util.concurrent.ConcurrentHashMap as its cache store. Its simplicity
         * makes it a tempting choice for development, testing, or basic applications. But because its cache storage is
         * memory-based and thus tied to the lifecycle of the application, it’s probably not an ideal choice for larger
         * production applications.
         */
        return new ConcurrentMapCacheManager();
    }

    @Bean
    public EhCacheCacheManager cacheManager(net.sf.ehcache.CacheManager cm) {
        return new EhCacheCacheManager(cm);
    }

    @Bean
    public EhCacheManagerFactoryBean ehcache() {
        EhCacheManagerFactoryBean ehCacheFactoryBean = new EhCacheManagerFactoryBean();
        ehCacheFactoryBean.setConfigLocation(new ClassPathResource("com/habuma/spittr/cache/ehcache.xml"));
        return ehCacheFactoryBean;
    }

}
