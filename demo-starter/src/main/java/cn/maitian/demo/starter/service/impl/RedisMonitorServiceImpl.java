package cn.maitian.demo.starter.service.impl;

import cn.maitian.demo.starter.service.MonitorService;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author: zhudawei
 * @date: 2020/8/13
 * @description:
 */
public class RedisMonitorServiceImpl implements MonitorService {

    private RedisTemplate template;

    @Override
    public Boolean enable() {
        try {
            String key = "zhudawei:test:starter";
            String value = "true";
            template.opsForValue().set(key, value);
            template.expire(key, 20, TimeUnit.SECONDS);
            boolean result = template.opsForValue().get(key).equals(value);
//            template.delete(key);
            return result;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public String getDescription() {
        return "redis-monitor-test";
    }

    public RedisMonitorServiceImpl(RedisTemplate template){
        this.template = template;
    }
}
