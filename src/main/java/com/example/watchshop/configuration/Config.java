package com.example.watchshop.configuration;

import com.example.watchshop.service.WatchService;
import com.example.watchshop.service.WatchServiceImpl;
import com.example.watchshop.utils.WatchUtil;
import com.example.watchshop.utils.WatchUtilImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public WatchUtil watchUtil(){
        return new WatchUtilImpl();
    }
}
