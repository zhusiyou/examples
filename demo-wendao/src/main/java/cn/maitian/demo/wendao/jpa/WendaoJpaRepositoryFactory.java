package cn.maitian.demo.wendao.jpa;

import org.springframework.data.jpa.provider.PersistenceProvider;
import org.springframework.data.jpa.provider.QueryExtractor;
import org.springframework.data.jpa.repository.query.JpaQueryLookupStrategy;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.query.QueryLookupStrategy;
import org.springframework.data.repository.query.QueryMethodEvaluationContextProvider;
import org.springframework.lang.Nullable;

import javax.persistence.EntityManager;
import java.util.Optional;

/**
 * @author: zhudawei
 * @date: 2020/8/24
 * @description:
 */
public class WendaoJpaRepositoryFactory extends JpaRepositoryFactory {

    private final EntityManager entityManager;
    private final QueryExtractor queryExtractor;

    public WendaoJpaRepositoryFactory(EntityManager entityManager) {
        super(entityManager);

        this.entityManager = entityManager;
        this.queryExtractor = PersistenceProvider.fromEntityManager(entityManager);
    }


    @Override
    protected Optional<QueryLookupStrategy> getQueryLookupStrategy(@Nullable QueryLookupStrategy.Key key,

                                                                   QueryMethodEvaluationContextProvider evaluationContextProvider) {

        //        return Optional.of();
        //TODO:
        return Optional.of(new WendaoQueryLookupStrategy(entityManager, key, this.queryExtractor, evaluationContextProvider));
    }
}
