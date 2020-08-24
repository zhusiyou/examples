package cn.maitian.demo.web.repository;

import cn.maitian.demo.web.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: zhudawei
 * @date: 2020/8/24
 * @description:
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
}
