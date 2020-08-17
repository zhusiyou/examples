package cn.maitian.demo.web.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author: zhudawei
 * @date: 2020/8/17
 * @description:
 */
@Entity
@Table(name = "t_user")
@Data
public class User {
    @Id
    @GeneratedValue(generator  = "idStrategy")
    @GenericGenerator(name = "idStrategy", strategy = "uuid")
    private String id;

    private String userName;
    private String password;
    private Integer age;
}
