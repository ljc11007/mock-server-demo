package com.example.mockserverdemo;

import com.example.mockserverdemo.init.ExpectationInit;
import org.mockserver.configuration.ConfigurationProperties;
import org.mockserver.integration.ClientAndServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;

@SpringBootApplication
public class MockServerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MockServerDemoApplication.class, args);
    }
    //https://blog.csdn.net/smilehappiness/article/details/108037725
    //来自于这个地址的不错方法
    @PostConstruct
    public void startMockServer() {
        ConfigurationProperties.enableCORSForAPI(true);
        //初始化期望配置类
        ConfigurationProperties.initializationClass(ExpectationInit.class.getName());

        //持久化期望数据
        ConfigurationProperties.persistExpectations(true);

        ClientAndServer mockServer = startClientAndServer(1080);
        System.out.println("mock server【" + mockServer + "】 start...");
    }


}
