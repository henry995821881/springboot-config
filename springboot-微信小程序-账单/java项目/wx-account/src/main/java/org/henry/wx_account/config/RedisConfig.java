package org.henry.wx_account.config;

import java.lang.reflect.Method;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration  
@EnableCaching  
public class RedisConfig extends CachingConfigurerSupport{  
  
    @Bean  
    public KeyGenerator wiselyKeyGenerator(){  
    	
        return new KeyGenerator() {  
         
            public Object generate(Object target, Method method, Object... params) {  
            	System.out.println("=======redis====method name="+method.getName());
                StringBuilder sb = new StringBuilder();  
                sb.append(target.getClass().getName());  
//                sb.append(method.getName());  
                sb.append(params[0].toString());
//                for (Object obj : params) {  
//                    sb.append(obj.toString());  
//                }  
                return sb.toString();  
            }  
        };  
  
  }  
  
    @Bean 
    public CacheManager cacheManager(  
            @SuppressWarnings("rawtypes") RedisTemplate redisTemplate) {  
        return new RedisCacheManager(redisTemplate);  
    }  
  
   
    @Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
    	
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		redisTemplate.setConnectionFactory(factory);
		redisTemplate.setKeySerializer(new StringRedisSerializer()); // key的序列化类型
		redisTemplate.setValueSerializer(new StringRedisSerializer()); // value的序列化类型
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		return redisTemplate;
		
		
		
	}  
} 