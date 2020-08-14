package cn.maitian.demo.web.controller;

import cn.maitian.demo.starter.service.DemoService;
import cn.maitian.demo.starter.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: zhudawei
 * @date: 2020/8/13
 * @description:
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @Autowired
    private List<MonitorService> monitorServices;

    @GetMapping("/starter/demo")
    public String getDemoText(){
        return demoService.getText();
    }

    @GetMapping("/monitor")
    public String monitor(){
        StringBuilder builder = new StringBuilder();
        monitorServices.stream().forEach(service-> builder.append(service.getClass().getName() + ": " + service.enable() + ": " + service.getDescription() + "\n"));
        return builder.toString();
    }
}
