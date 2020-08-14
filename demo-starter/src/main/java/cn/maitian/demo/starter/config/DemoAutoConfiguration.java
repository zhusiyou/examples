package cn.maitian.demo.starter.config;

import cn.maitian.demo.starter.service.DemoService;
import cn.maitian.demo.starter.service.MonitorService;
import cn.maitian.demo.starter.service.impl.DemoServiceImpl;
import cn.maitian.demo.starter.service.impl.JpaMonitorServiceImpl;
import cn.maitian.demo.starter.service.impl.RedisMonitorServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author: zhudawei
 * @date: 2020/8/13
 * @description:
 */
@Configuration
public class DemoAutoConfiguration {

    @Bean
    public DemoService getBean(){
        return new DemoServiceImpl();
    }

    @Bean
    @ConditionalOnBean(RedisTemplate.class)
    public MonitorService getRedisMonitorBean(RedisTemplate redisTemplate){
        return new RedisMonitorServiceImpl(redisTemplate);
    }

    @Bean
    public MonitorService getJpaMonitorBean(){
        return new JpaMonitorServiceImpl();
    }
}
