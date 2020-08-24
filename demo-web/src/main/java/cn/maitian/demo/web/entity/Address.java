package cn.maitian.demo.web.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author: zhudawei
 * @date: 2020/8/24
 * @description:
 */
@Entity
@Table(name = "t_address")
@Data
public class Address {

    @Id
    @GeneratedValue(generator  = "idStrategy")
    @GenericGenerator(name = "idStrategy", strategy = "uuid2")
    private String id;

    private String province;
    private String city;
    private String street;

    private String linkman;
    private String mobile;

    private String memberId;

}
