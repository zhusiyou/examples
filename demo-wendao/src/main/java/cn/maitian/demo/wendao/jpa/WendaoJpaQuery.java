package cn.maitian.demo.wendao.jpa;


import lombok.Setter;
import org.springframework.data.jpa.repository.query.*;
import org.springframework.data.repository.query.ParametersParameterAccessor;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * @author: zhudawei
 * @date: 2020/8/24
 * @description:
 */
public class WendaoJpaQuery extends AbstractJpaQuery {

    @Setter
    private QueryWendao queryWendao;
//    @Setter
//    private Class<?> queryClass;


    public WendaoJpaQuery(JpaQueryMethod method, EntityManager entityManager){
        super(method, entityManager);
    }


    @Override
    protected Query doCreateQuery(JpaParametersParameterAccessor accessor) {
        JpaQueryMethod method = super.getQueryMethod();
        EntityManager em = super.getEntityManager();

        if(queryWendao.nativeQuery()){
            Class<?> type = method.getResultProcessor().withDynamicProjection(
                    new ParametersParameterAccessor(method.getParameters(), accessor.getValues())).getReturnedType().getDomainType();
            return em.createNativeQuery(queryWendao.value(), type);
        }
        return em.createQuery(queryWendao.value());
    }

    @Override
    protected Query doCreateCountQuery(JpaParametersParameterAccessor accessor) {
        return null;
    }
}
