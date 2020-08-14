package cn.maitian.demo.monitor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhudawei
 * @date: 2020/8/13
 * @description:
 */
@RestController
@RequestMapping("/monitor")
public class MonitorController {

    @GetMapping("/test")
    public String test(){
        return "monitor test!";
    }
}
