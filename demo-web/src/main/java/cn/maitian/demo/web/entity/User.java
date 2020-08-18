package cn.maitian.demo.web.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "t_user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roles;
}
