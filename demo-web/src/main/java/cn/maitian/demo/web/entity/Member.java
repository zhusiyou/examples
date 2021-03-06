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
@Table(name = "t_member")
@Data
public class Member {
    @Id
    @GeneratedValue(generator  = "idStrategy")
    @GenericGenerator(name = "idStrategy", strategy = "uuid2")
    private String id;

    private String name;
    private String mobile;
}
