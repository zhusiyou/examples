package cn.maitian.demo.wendao.jpa;

import org.springframework.data.jpa.provider.QueryExtractor;
import org.springframework.data.jpa.repository.query.DefaultJpaQueryMethodFactory;
import org.springframework.data.jpa.repository.query.EscapeCharacter;
import org.springframework.data.jpa.repository.query.JpaQueryLookupStrategy;
import org.springframework.data.jpa.repository.query.JpaQueryMethodFactory;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.repository.core.NamedQueries;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.query.QueryLookupStrategy;
import org.springframework.data.repository.query.QueryMethodEvaluationContextProvider;
import org.springframework.data.repository.query.RepositoryQuery;

import javax.persistence.EntityManager;
import java.lang.reflect.Method;

/**
 * @author: zhudawei
 * @date: 2020/8/24
 * @description:
 */
public class WendaoQueryLookupStrategy implements QueryLookupStrategy {


    private DefaultJpaQueryMethodFactory queryMethodFactory;
    private final QueryLookupStrategy defaultQueryLookupStrategy;
    private final EntityManager entityManager;

    public WendaoQueryLookupStrategy(EntityManager entityManager, QueryLookupStrategy.Key key,
                                     QueryExtractor extractor, QueryMethodEvaluationContextProvider provider){
        this.queryMethodFactory = new DefaultJpaQueryMethodFactory(extractor);
        this.defaultQueryLookupStrategy = JpaQueryLookupStrategy.create(entityManager,
                this.queryMethodFactory, key, provider, EscapeCharacter.DEFAULT);
        this.entityManager = entityManager;
    }

    @Override
    public RepositoryQuery resolveQuery(Method method,
                                        RepositoryMetadata metadata,
                                        ProjectionFactory factory,
                                        NamedQueries namedQueries) {
        QueryWendao annotation = method.getAnnotation(QueryWendao.class);

        if(annotation==null){
            RepositoryQuery query = this.defaultQueryLookupStrategy.resolveQuery(method,
                    metadata,
                    factory,
                    namedQueries);
            return query;
        }

        WendaoJpaQuery query = new WendaoJpaQuery(((JpaQueryMethodFactory) this.queryMethodFactory)
                .build(method, metadata, factory), this.entityManager);
        query.setQueryWendao(annotation);
//        query.setQueryClass(method.getDeclaringClass());

        return query;
    }
}
