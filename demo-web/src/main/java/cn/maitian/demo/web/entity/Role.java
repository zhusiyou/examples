package cn.maitian.demo.web.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author: zhudawei
 * @date: 2020/8/17
 * @description:
 */
@Entity
@Table(name = "t_role")
@Data
public class Role {

    @Id
    @GeneratedValue(generator  = "idStrategy")
    @GenericGenerator(name = "idStrategy", strategy = "uuid")
    private String id;

    private String roleName;

}
