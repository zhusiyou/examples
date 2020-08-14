package cn.maitian.demo.starter.service;

/**
 * @author: zhudawei
 * @date: 2020/8/13
 * @description:
 */
public interface MonitorService {
    /**
     * 监控对象是否可用
     * @return
     */
    Boolean enable();

    /**
     * 具体说明
     * @return
     */
    String getDescription();
}
