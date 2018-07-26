package com.spring.components.config.view.tiles;


import com.spring.enumeration.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
public class TilesConfiguration {

    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer=new TilesConfigurer();
        tilesConfigurer.setDefinitions(new String[]{"/WEB-INF/views/tiles/layout/tiles.xml"});
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }

    @Bean
    public ViewResolver tilesViewResolver() {
        TilesViewResolver tilesViewResolver= new CustomTilesViewResolver();
        tilesViewResolver.setOrder(Order.TILES.ordinal());
        return tilesViewResolver;
    }
}
