package cn.maitian.demo.monitor;

import cn.maitian.demo.monitor.config.MonitorAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author: zhudawei
 * @date: 2020/8/13
 * @description:
 */
@Documented
@Target(TYPE)
@Retention(RUNTIME)
//@ComponentScan(basePackages = {"cn.maitian.demo.monitor"})
@Import({MonitorAutoConfiguration.class})
public @interface EnableMonitor {
}
