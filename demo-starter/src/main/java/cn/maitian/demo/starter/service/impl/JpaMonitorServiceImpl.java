package cn.maitian.demo.starter.service.impl;

import cn.maitian.demo.starter.service.MonitorService;

/**
 * @author: zhudawei
 * @date: 2020/8/13
 * @description:
 */
public class JpaMonitorServiceImpl implements MonitorService {
    @Override
    public Boolean enable() {
        return true;
    }

    @Override
    public String getDescription() {
        return "jpa-monitor-test";
    }
}
