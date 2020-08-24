package cn.maitian.demo.web.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: zhudawei
 * @date: 2020/8/24
 * @description:
 */
@Data
@AllArgsConstructor
public class DeliveryAddress {
    private String id;

    private String province;
    private String city;
    private String street;

    private String linkman;
    private String mobile;

    private String memberName;
    private String memberMobile;
}
