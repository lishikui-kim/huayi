package com.example.mimile.dao;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class ProdDBConnecter implements DBConnecter {
    @Override
    public String configure() {
        return "生产环境";
    }
}
