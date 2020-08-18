package cn.maitian.demo.web.repository;

import cn.maitian.demo.web.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: zhudawei
 * @date: 2020/8/17
 * @description:
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
}
