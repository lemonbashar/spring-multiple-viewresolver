package com.spring.components.config.view.thymleaf;


import com.spring.enumeration.Order;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
public class ThymeLeafConfiguration implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    private boolean isDecoupled=true;
    private boolean isCacheable=true;

    @Bean
    public ViewResolver viewResolver(ITemplateEngine templateEngine) {
        ThymeleafViewResolver viewResolver=new CustomThymeLeafResolver();
        viewResolver.setTemplateEngine(templateEngine);
        viewResolver.setOrder(Order.THYMELEAF.ordinal());
        return viewResolver;
    }

    @Bean
    public ITemplateEngine templateEngine(ITemplateResolver templateResolver) {
        SpringTemplateEngine templateEngine=new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    @Bean
    public ITemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver=new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        templateResolver.setUseDecoupledLogic(isDecoupled);
        templateResolver.setCacheable(isCacheable);
        templateResolver.setTemplateMode("HTML5");

        return templateResolver;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}













