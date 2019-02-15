
package com.slife.java.share;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import app.myoss.cloud.web.spring.boot.BootApplication;
import lombok.extern.slf4j.Slf4j;

/**
 * 项目启动类
 *
 * @author Joyce.xu
 * @since 2019年2月13日 下午2:18:21
 */
@Slf4j
@SpringBootApplication
public class RunApplication {
    /**
     * 项目启动类
     *
     * @param args 启动参数
     */
    public static void main(String[] args) {
        BootApplication.run(log, RunApplication.class, args);
    }
}
