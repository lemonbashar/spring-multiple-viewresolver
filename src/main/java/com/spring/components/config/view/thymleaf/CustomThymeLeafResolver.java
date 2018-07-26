package com.spring.components.config.view.thymleaf;


import com.spring.costants.ViewResolverPrefixes;
import com.spring.utility.Utility;
import com.spring.utility.impl.UtilityImpl;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import java.util.Locale;

public class CustomThymeLeafResolver extends ThymeleafViewResolver {

    private Utility utility;

    public CustomThymeLeafResolver() {
        this.utility=new UtilityImpl();
    }

    @Override
    protected boolean canHandle(String viewName, Locale locale) {
        return utility.isStartWithAnything(viewName, ViewResolverPrefixes.THYMELEAF);
    }
}
