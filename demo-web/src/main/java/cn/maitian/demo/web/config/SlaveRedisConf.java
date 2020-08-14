package cn.maitian.demo.web.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author: zhudawei
 * @date: 2020/7/11
 * @description: 存在spring.redis.slave.host时才生效
 */
@Configuration
@ConditionalOnProperty(prefix = "spring.redis.slave", name = "host")
public class SlaveRedisConf extends RedisConfig {

    @Bean(name = "slaveJedisConnectionFactory")
    @Override
    public JedisConnectionFactory getRedisConnFactory(@Qualifier("slaveRedisProperties")RedisProperties redisProperties) {
        return super.getRedisConnFactory(redisProperties);
    }

    @Bean(name = "slaveRedisTemplate")
    @Override
    public RedisTemplate<String, Object> buildRedisTemplate(@Qualifier("slaveJedisConnectionFactory") RedisConnectionFactory redisConnectionFactory) {
        return super.buildRedisTemplate(redisConnectionFactory);
    }

    @Bean(name = "slaveRedisProperties")
    @ConfigurationProperties(prefix = "spring.redis.slave")
    public RedisProperties getBaseDBProperties() {
        return new RedisProperties();
    }
}
