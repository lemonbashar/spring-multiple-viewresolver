package com.spring.components.config.mvc;

import com.spring.costants.ApplicationProfile;
import com.spring.costants.ViewResolverPrefixes;
import com.spring.enumeration.LoadOnStartup;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class SpringMvcConfigurer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext applicationContext=new AnnotationConfigWebApplicationContext();
        applicationContext.register(WebConfig.class);
        applicationContext.setServletContext(servletContext);
        servletContext.setInitParameter("spring.profiles.active", ApplicationProfile.DEV); /*Active at Startup*/

        ServletRegistration.Dynamic dynamic=servletContext.addServlet(DispatcherServlet.class.getSimpleName(),new DispatcherServlet(applicationContext));
        dynamic.setMultipartConfig(new MultipartConfigElement("/upload/dispatch/data",Integer.MAX_VALUE,Integer.MAX_VALUE,0));
        dynamic.addMapping(ViewResolverPrefixes.FOR_DISPATCHER_SERVLET);
        dynamic.setLoadOnStartup(LoadOnStartup.DISPATCHER_SERVLET.ordinal());
    }
}
