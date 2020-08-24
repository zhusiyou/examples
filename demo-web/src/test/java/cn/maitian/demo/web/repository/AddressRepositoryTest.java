package cn.maitian.demo.web.repository;

import cn.maitian.demo.web.domain.DeliveryAddress;
import cn.maitian.demo.web.domain.DemoAddress;
import cn.maitian.demo.web.entity.Address;
import com.alibaba.fastjson.JSON;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @author: zhudawei
 * @date: 2020/8/24
 * @description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressRepositoryTest {
    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void testAdd(){
        Address address = new Address();
        address.setProvince("bj");
        address.setCity("bj");
        address.setStreet("street-qiyang");
        address.setLinkman("haha");
        address.setMobile("18200010001");
        address.setMemberId("b5bbf556-11ef-481a-9ccb-151a2c624ef2");

        Address address1 = new Address();
        address1.setProvince("hebei");
        address1.setCity("tangshan");
        address1.setStreet("street-yunjing");
        address1.setLinkman("hehe");
        address1.setMobile("18200010002");
        address1.setMemberId("b5bbf556-11ef-481a-9ccb-151a2c624ef2");

        addressRepository.saveAll(Arrays.asList(address, address1));
    }

    @Test
    public void testDto(){
        List<DeliveryAddress> list = addressRepository.getAddressByMemberName("first-member");

        Assert.assertTrue(list.size()>0);
        Assert.assertTrue(list.stream().allMatch(item->item.getMemberName().equals("first-member")));
    }

    @Test
    public void testNativa(){
        List<DemoAddress> list = addressRepository.getAddressesByMemberName("first-member");

        System.out.println(JSON.toJSONString(list));

        Assert.assertTrue(list.size()>0);
        Assert.assertTrue(list.stream().allMatch(item->item.getMemberName().equals("first-member")));
    }
}
