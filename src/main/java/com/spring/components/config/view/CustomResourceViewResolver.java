package com.spring.components.config.view;

import com.spring.costants.ViewResolverPrefixes;
import com.spring.utility.Utility;
import com.spring.utility.impl.UtilityImpl;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Locale;

public class CustomResourceViewResolver extends InternalResourceViewResolver {

    private Utility utility=null;

    public CustomResourceViewResolver() {
        this.utility=new UtilityImpl();
    }

    @Override
    protected boolean canHandle(String viewName, Locale locale) {
        return utility.isStartWithAnything(viewName, ViewResolverPrefixes.JSP);
    }
}
