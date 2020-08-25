package cn.maitian.demo.web.repository;

import cn.maitian.demo.web.entity.User;
import cn.maitian.demo.wendao.jpa.QueryWendao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: zhudawei
 * @date: 2020/8/17
 * @description:
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Page<User> findAll(Specification<User> specification, Pageable pageable);

    @QueryWendao(value = "select u from User u")
    List<User> finaAllFromWendao();

    @QueryWendao(value = "select u.id,u.age,u.password,u.user_name from t_user u", nativeQuery = true)
    List<User> finaAllFromWendaoNative();
}
