package org.henry.wx_account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan(basePackages ="org.henry.wx_account")
@SpringBootApplication
@EnableTransactionManagement //¿ªÆôÊÂÎñ
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}