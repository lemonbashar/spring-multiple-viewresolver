package com.spring.components.config.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan(value = "com.spring.components",excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = EnableWebMvc.class)})
public class SpringAppConfig {
    @Bean
    @ApplicationScope
    public Properties properties() {
        Properties properties=new Properties();
        try {
            properties.load(new FileInputStream("spring-app.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
