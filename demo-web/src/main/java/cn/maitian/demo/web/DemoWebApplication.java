package cn.maitian.demo.web;

import cn.maitian.demo.monitor.EnableMonitor;
import cn.maitian.demo.wendao.EnableWendao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMonitor
@EnableWendao
public class DemoWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoWebApplication.class, args);
    }

}
