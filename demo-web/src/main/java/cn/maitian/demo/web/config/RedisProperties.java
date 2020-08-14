package cn.maitian.demo.web.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: zhudawei
 * @date: 2020/7/11
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RedisProperties {
    private Integer database;
    private String host;
    private Integer port;
    private String password;
    private Integer timeout;
    private Pool pool;

    @Data
    public static class Pool {
        private Integer maxActive;
        private Integer minIdle;
        private Integer maxIdle;
        private Integer maxWait;
    }
}
