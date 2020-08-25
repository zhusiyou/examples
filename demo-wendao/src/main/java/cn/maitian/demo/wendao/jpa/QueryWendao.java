package cn.maitian.demo.wendao.jpa;

import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.lang.annotation.*;

/**
 * @author: zhudawei
 * @date: 2020/8/24
 * @description:
 */
@Documented
@QueryAnnotation
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface QueryWendao {
    boolean nativeQuery() default false;
    String value() default "";
}
