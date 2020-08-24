package cn.maitian.demo.web.repository;

import cn.maitian.demo.web.entity.Member;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * @author: zhudawei
 * @date: 2020/8/24
 * @description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void testAdd(){
        Member member = new Member();
        member.setMobile("13300010001");
        member.setName("first-member");

        Member member1 = new Member();
        member1.setMobile("13300010002");
        member1.setName("second-member");

        memberRepository.saveAll(Arrays.asList(member, member1));

        System.out.println(member.getId());
        System.out.println(member1.getId());

        Assert.assertNotNull(member.getId());
        Assert.assertNotNull(member1.getId());
    }
}
