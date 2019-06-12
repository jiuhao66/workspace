package com.yc.cache;

import com.yc.cache.bean.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheApplicationTests {

	// 操作字符串的
	@Autowired
	StringRedisTemplate stringRedisTemplate;

	//操作   对象
	@Autowired
	RedisTemplate redisTemplate;

	@Autowired
	RedisTemplate<Object,Employee> employeeRedisTemplate;

	/**
	 * stringRedisTemplate.opsForValue()     字符串
	 * stringRedisTemplate.opsForList()      List(列表) ,
	 * stringRedisTemplate.opsForSet()       Set(集合) ,
	 * stringRedisTemplate.opsForHash()      Hash(散列),
	 * stringRedisTemplate.opsForZSet()      ZSet(有序集合)
	 *
	 *
	 */
	@Test
	public void redisStringTest(){

//		System.out.println(stringRedisTemplate.opsForValue().get("name"));
//		stringRedisTemplate.opsForList().leftPush("mylist", "1");
//		stringRedisTemplate.opsForList().leftPush("mylist", "1");
//		stringRedisTemplate.opsForList().leftPush("mylist", "2");
//		stringRedisTemplate.opsForList().leftPush("mylist", "3");

		// 默认 如果保存对象, 使用jdk序列化机制 ,序列化机制后的数据保存到redis中


//		将数据以json 的方式保存
		   // 自己将对象转化为json保存
		   //  配置项目的RedisTemplate 的序列化规则

//		Employee employee = new Employee();
//		employee.setEmail("157922018@qq.com");
//		employee.setLastName("大佬");
//		employee.setId(5);
//		employee.setdId(3);
//		employee.setGender(6);
//		employeeRedisTemplate.opsForValue().set("emp01",employee );
		Employee employee = employeeRedisTemplate.opsForValue().get("emp01");
		System.out.println(employee);
		System.out.println(employee.getLastName());

	}

	@Test
	public void contextLoads() {

	}

}
