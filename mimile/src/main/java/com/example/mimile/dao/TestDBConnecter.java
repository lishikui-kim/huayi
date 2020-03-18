package com.example.mimile.dao;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestDBConnecter implements DBConnecter {
    @Override
    public String configure() {
        return "测试环境";
    }
}
