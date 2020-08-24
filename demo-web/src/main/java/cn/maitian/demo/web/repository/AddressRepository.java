package cn.maitian.demo.web.repository;

import cn.maitian.demo.web.domain.DeliveryAddress;
import cn.maitian.demo.web.domain.DemoAddress;
import cn.maitian.demo.web.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: zhudawei
 * @date: 2020/8/24
 * @description:
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
    @Query("select new cn.maitian.demo.web.domain.DeliveryAddress(" +
            "t.id, t.province, t.city, t.street, t.linkman, t.mobile, " +
            "m.name, m.mobile" +
            ") from Address t, Member m where t.memberId = m.id and m.name = ?1")
    List<DeliveryAddress> getAddressByMemberName(String memberName);


    @Query(nativeQuery = true, value =
            "select t.province, t.city, t.mobile, t.linkman, " +
                    "m.name as memberName, m.mobile as memberMobile " +
                    "from t_address t join t_member m on t.member_id = m.id where m.name = ?1 ")
    List<DemoAddress> getAddressesByMemberName(String memberName);
}
