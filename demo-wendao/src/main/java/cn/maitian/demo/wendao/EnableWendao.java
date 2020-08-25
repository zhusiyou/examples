package cn.maitian.demo.wendao;

import cn.maitian.demo.wendao.jpa.WendaoJpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.lang.annotation.*;

/**
 * @author: zhudawei
 * @date: 2020/8/24
 * @description:
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@EnableJpaRepositories(repositoryFactoryBeanClass = WendaoJpaRepositoryFactoryBean.class)
public @interface EnableWendao {
}
