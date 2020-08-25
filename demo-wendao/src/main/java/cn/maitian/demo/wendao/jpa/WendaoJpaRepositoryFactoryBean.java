package cn.maitian.demo.wendao.jpa;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;

/**
 * @author: zhudawei
 * @date: 2020/8/24
 * @description:
 */
public class WendaoJpaRepositoryFactoryBean<T extends Repository<S, ID>, S, ID> extends JpaRepositoryFactoryBean<T, S, ID> {
    public WendaoJpaRepositoryFactoryBean(Class<? extends T> repositoryInterface) {
        super(repositoryInterface);
    }

    @Override
    public RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager){
        return new WendaoJpaRepositoryFactory(entityManager);
    }
}
