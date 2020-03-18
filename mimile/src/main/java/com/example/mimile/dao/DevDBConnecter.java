package com.example.mimile.dao;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevDBConnecter implements DBConnecter {
    @Override
    public String configure() {
        return "开发环境";
    }
}
