package com.zl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zhagnlei
 * @ProjectName: security-auth
 * @create 2019-11-09 22:57
 * @Version: 1.0
 * <p>Copyright: Copyright (zl) 2019</p>
 **/
@SpringBootApplication
@RestController
@EnableSwagger2
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/hello")
    public String helloWord() {
        return "hello spring security";
    }
}
