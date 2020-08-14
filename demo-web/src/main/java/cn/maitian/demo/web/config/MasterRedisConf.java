package cn.maitian.demo.web.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author: zhudawei
 * @date: 2020/7/11
 * @description: 存在spring.redis.master.host时才生效
 */

@Configuration
@ConditionalOnProperty(prefix = "spring.redis.master", name = "host")
public class MasterRedisConf extends RedisConfig{
    @Primary
    @Bean(name = "masterJedisConnectionFactory")
    @Override
    public JedisConnectionFactory getRedisConnFactory(@Qualifier("masterRedisProperties") RedisProperties redisProperties){
        return super.getRedisConnFactory(redisProperties);
    }

    @Primary
    @Bean(name = "masterRedisTemplate")
    @Override
    public RedisTemplate<String, Object> buildRedisTemplate(@Qualifier("masterJedisConnectionFactory") RedisConnectionFactory redisConnectionFactory) {
        return super.buildRedisTemplate(redisConnectionFactory);
    }

    @Bean(name = "masterRedisProperties")
    @ConfigurationProperties(prefix = "spring.redis.master")
    public RedisProperties getBaseDBProperties() {
        return new RedisProperties();
    }
}
