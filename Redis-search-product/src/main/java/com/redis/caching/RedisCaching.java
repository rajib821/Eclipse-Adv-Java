package com.redis.caching;

import java.time.Duration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;


@Configuration
@EnableCaching
public class RedisCaching {
	@Bean
	public RedisConnectionFactory redisConnectionFactory() {

		RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration("working-herring-22870.upstash.io",
				6379);
		redisConfig.setUsername("default");
		redisConfig.setPassword("AVlWAAIncDIxYjI2NDljYzg4ODI0NjlmOGYwNDYwMGRhNjkwOGQ1OXAyMjI4NzA"); 

		LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder()
				.commandTimeout(Duration.ofSeconds(10)).shutdownTimeout(Duration.ofMillis(100)).useSsl().build();

		return new LettuceConnectionFactory(redisConfig, clientConfig);
	}

	@Bean
	public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {

		RedisCacheConfiguration cacheConfig = RedisCacheConfiguration.defaultCacheConfig()
				.entryTtl(Duration.ofMinutes(1)) // TTL
				.serializeValuesWith(RedisSerializationContext.SerializationPair
						.fromSerializer(new GenericJackson2JsonRedisSerializer()));

		return RedisCacheManager.builder(connectionFactory).cacheDefaults(cacheConfig).build();
	}
}
