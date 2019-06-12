package com.yc.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 *
 * 整合 redis :
 * 引入 redis  的  starter
 *
 * 配置 redis
 *
 * 测试缓存
 *     原理 CacheManager == Cache 缓存组件来实际给缓存中存取数据
 *     1) , 引入redis的starter ,容器中保存的是 RedisCacheManger;
 *     2) , RedisCacheManager 帮我们创建 RedisCache 来作为缓存组件; RedisCache通过操作redis缓存数据的
 *
 */
@MapperScan("com.yc.cache.mapper")
@SpringBootApplication
@EnableCaching
public class CacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(CacheApplication.class, args);
	}

}
