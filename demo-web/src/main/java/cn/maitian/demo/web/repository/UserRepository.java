package cn.maitian.demo.web.repository;

import cn.maitian.demo.web.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: zhudawei
 * @date: 2020/8/17
 * @description:
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Page<User> findAll(Specification<User> specification, Pageable pageable);
}
