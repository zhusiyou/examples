package cn.maitian.demo.starter.service.impl;

import cn.maitian.demo.starter.service.DemoService;

/**
 * @author: zhudawei
 * @date: 2020/8/13
 * @description:
 */
public class DemoServiceImpl implements DemoService {
    @Override
    public String getText() {
        return "service from starter";
    }
}
