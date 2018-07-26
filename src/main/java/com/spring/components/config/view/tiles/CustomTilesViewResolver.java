package com.spring.components.config.view.tiles;


import com.spring.costants.ViewResolverPrefixes;
import com.spring.utility.Utility;
import com.spring.utility.impl.UtilityImpl;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import java.util.Locale;

public class CustomTilesViewResolver extends TilesViewResolver{

    private Utility utility=null;

    public CustomTilesViewResolver() {
        this.utility=new UtilityImpl();
    }

    @Override
    protected boolean canHandle(String viewName, Locale locale) {
        return utility.isStartWithAnything(viewName, ViewResolverPrefixes.TILES);
    }
}
