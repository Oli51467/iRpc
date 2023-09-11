package com.sdu.provider;

import com.sdu.irpc.framework.common.annotation.EnableIrpc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan("com.sdu")
@MapperScan("com.sdu")
@EnableIrpc(basePackages = "com.sdu.provider.impl")
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class SpringProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProviderApplication.class, args);
    }
}