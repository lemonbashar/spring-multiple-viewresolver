package com.spring.components.config.view;

import com.spring.enumeration.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class JspViewConfigurer {

    @Bean
    public ViewResolver internalViewResolver() {
        InternalResourceViewResolver resolver=new CustomResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        resolver.setOrder(Order.BASIC.ordinal());
        return resolver;
    }

}
