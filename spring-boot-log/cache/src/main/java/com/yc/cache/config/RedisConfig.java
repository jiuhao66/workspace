package com.yc.cache.config;

import com.yc.cache.bean.Employee;
import org.springframework.cache.Cache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * @author LX
 * @date 2019/6/11 - 20:01
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<Object,Employee> empRedisTemplate(
            RedisConnectionFactory redisConnectionFactory
    ){

        RedisTemplate<Object, Employee> redisTemplate = new RedisTemplate<>();

        redisTemplate.setConnectionFactory(redisConnectionFactory);

        redisTemplate.setDefaultSerializer(new Jackson2JsonRedisSerializer<Employee>(Employee.class));
        return redisTemplate;
    }

    /**
     * 定制缓存的 的 一些规则
     * @param empRedisTemplate
     * @return
     */
    @Bean
    public RedisCacheManager empRedisCacheManager( RedisTemplate<Object,Employee> empRedisTemplate){
        RedisCacheManager cacheManager = new RedisCacheManager(empRedisTemplate);

        // key 多了一个前缀
        // 在这个地方设置了  使用前缀   会将 CacheName 作为前缀
        cacheManager.setUsePrefix(true);

        return cacheManager;
    }
}
