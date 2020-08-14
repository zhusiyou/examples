package cn.maitian.demo.web.config;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author: zhudawei
 * @date: 2020/7/11
 * @description:
 */
public class RedisConfig {
    public JedisConnectionFactory getRedisConnFactory(RedisProperties redisProperties) {
        /**
         * 主从已改用哨兵模式配置了 RedisSentinelConfiguration
         * 针对现有这种主从方式没有对应的配置类了，和现在的redisUtil的实现理念也不一样
         * 所以这里不做调整了
         */
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setDatabase(redisProperties.getDatabase());
        jedisConnectionFactory.setHostName(redisProperties.getHost());
        jedisConnectionFactory.setPort(redisProperties.getPort());
        jedisConnectionFactory.setPassword(redisProperties.getPassword());
        jedisConnectionFactory.setTimeout(redisProperties.getTimeout());

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(redisProperties.getPool().getMaxIdle());
        jedisPoolConfig.setMinIdle(redisProperties.getPool().getMinIdle());
        jedisPoolConfig.setMaxTotal(redisProperties.getPool().getMaxActive());
        jedisPoolConfig.setMaxWaitMillis(redisProperties.getPool().getMaxWait());
        jedisPoolConfig.setTestOnBorrow(true);

        jedisConnectionFactory.setPoolConfig(jedisPoolConfig);

        return jedisConnectionFactory;
    }

    public RedisTemplate buildRedisTemplate(RedisConnectionFactory redisConnectionFactory){

        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);


        RedisSerializer redisSerializer = getValueSerializer();
        RedisSerializer keySerializer = getKeySerializer();

        redisTemplate.setKeySerializer(keySerializer);
        redisTemplate.setValueSerializer(redisSerializer);

        redisTemplate.setHashKeySerializer(keySerializer);
        redisTemplate.setHashValueSerializer(redisSerializer);

        return redisTemplate;
    }

    protected RedisSerializer getValueSerializer(){
        return new FastJsonRedisSerializer(Object.class);
    }

    protected RedisSerializer getKeySerializer(){
        return new StringRedisSerializer();
    }
}
