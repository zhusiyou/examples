package cn.maitian.demo.monitor.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: zhudawei
 * @date: 2020/8/13
 * @description:
 */
@Configuration
@ComponentScan(basePackages = {"cn.maitian.demo.monitor"})
@ConditionalOnWebApplication
public class MonitoryAutoConfiguration {
}
