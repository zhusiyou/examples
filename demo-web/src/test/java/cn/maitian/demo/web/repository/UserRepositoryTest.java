package cn.maitian.demo.web.repository;

import cn.maitian.demo.web.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    @Rollback
    public void testAdd(){
        User user = new User();
        user.setAge(5);
        user.setUserName("tom");
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
}
