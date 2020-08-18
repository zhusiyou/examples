package cn.maitian.demo.web.repository;

import cn.maitian.demo.web.entity.Role;
import cn.maitian.demo.web.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhudawei
 * @date: 2020/8/17
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
//    @Transactional
//    @Rollback
    public void testAdd(){
        User user = new User();
        user.setAge(5);
        user.setUserName("jack");
        user.setPassword("123");

        userRepository.save(user);

        System.out.println(user.getId());
        Assert.assertNotNull(user.getId());

        List<User> users = userRepository.findAll();
        Assert.assertTrue(users.size()>0);
    }


    @Test
    public void testDelete(){
        userRepository.deleteAll();
        Assert.assertTrue(userRepository.findAll().size()==0);
    }

    @Test
    public void testGet(){
        User user = userRepository.getOne("402837ba73fbca540173fbca5bc60000");
        Assert.assertTrue(user.getRoles().size() == 1);
        Assert.assertTrue(user.getRoles().get(0).getRoleName().equals("admin"));
    }

    @Test
    public void testJpaJoin(){
        Page<User> users = userRepository.findAll((root, query, builder)->{

            List<Predicate> predicates = new ArrayList<>();

            Join<User, Role> join = root.join("roles", JoinType.LEFT);

            predicates.add(builder.equal(join.get("roleName"), "guest"));

            return builder.and(predicates.toArray(new Predicate[predicates.size()]));

        }, PageRequest.of(0, 10));

        Assert.assertNotNull(users);
        Assert.assertTrue(users.getContent().size()>1);
//        Assert.assertTrue(users.getContent().get(0).getUserName().equals("tom"));

    }
}
