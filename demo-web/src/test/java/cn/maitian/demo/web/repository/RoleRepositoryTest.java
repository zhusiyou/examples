package cn.maitian.demo.web.repository;

import cn.maitian.demo.web.entity.Role;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * @author: zhudawei
 * @date: 2020/8/17
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void testAdd(){
        Role role = new Role();
        role.setRoleName("admin");

        Role role2 = new Role();
        role2.setRoleName("guest");

        roleRepository.saveAll(Arrays.asList(new Role[]{role, role2}));

        Assert.assertNotNull(role.getId());
        Assert.assertNotNull(role2.getId());
    }
}
