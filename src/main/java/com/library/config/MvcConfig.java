package com.library.config;

import org.apache.tiles.Attribute;
import org.apache.tiles.Definition;
import org.apache.tiles.definition.LocaleDefinitionsFactory;
import org.apache.tiles.definition.UnresolvingLocaleDefinitionsFactory;
import org.apache.tiles.request.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Ievgen Usenko
 * Date: 8/28/14
 */
@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {

//    private static final Map<String, Definition> tiles = new HashMap<>();
//    private static final Attribute TEMPLATE = new Attribute("/WEB-INF/views/layout/layout.jsp");

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/").setViewName("index");
//        registry.addViewController("/login").setViewName("login");
    }

    @Bean
    public UrlBasedViewResolver tilesViewResolver(){

        UrlBasedViewResolver tilesViewResolver = new UrlBasedViewResolver();
        tilesViewResolver.setViewClass(TilesView.class);
        return tilesViewResolver;
    }
    @Bean
    public TilesConfigurer tilesConfigurer(){

        String[] definitions = new String[] {
                "/WEB-INF/layouts/layouts.xml",
                "/WEB-INF/views/**/views.xml" /*Scans directories for Tiles configurations */
        };

        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(definitions);
        return tilesConfigurer;

    }

//    @Bean
//    public ViewResolver getViewResolver() {
////        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
//        resolver.setPrefix("/WEB-INF/view/");
//        resolver.setViewClass(TilesView.class);
//        resolver.setSuffix(".jsp");
//        return resolver;
//    }

//    @Bean
//    public TilesConfigurer tilesConfigurer() {
//        TilesConfigurer tilesConfigurer = new TilesConfigurer();
//        tilesConfigurer.setDefinitionsFactoryClass(JavaDefinitionsFactory.class);
//        tilesConfigurer.setDefinitions();
//
//        addDefinition("home", "Home", "/WEB-INF/view/hello.jsp");
////        addDefinition("signin", "Sign in", "/WEB-INF/views/signin.jsp");
////        addDefinition("signin/facebook", "Sign in", "/WEB-INF/views/signin.jsp");
//
//        return tilesConfigurer;
//    }

//    private void addDefinition(String name, String title, String body) {
//        Map<String, Attribute> attributes = getDefaultAttributes();
//
//        attributes.put("title", new Attribute(title));
//        attributes.put("body", new Attribute(body));
//
//        tiles.put(name, new Definition(name, TEMPLATE, attributes));
//    }

//    private Map<String, Attribute> getDefaultAttributes() {
//        Map<String, Attribute> attributes = new HashMap<String,Attribute>();
//
////        attributes.put("header", new Attribute("/WEB-INF/views/layout/menu.jsp"));
//        attributes.put("menu", new Attribute("/WEB-INF/view/layout/menu.jsp"));
//        attributes.put("footer", new Attribute("/WEB-INF/view/layout/footer.jsp"));
//
//        return attributes;
//    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
//
//    public static class JavaDefinitionsFactory extends UnresolvingLocaleDefinitionsFactory {
//
//        public JavaDefinitionsFactory(){}
//
//        @Override
//        public Definition getDefinition(String name, Request tilesContext) {
////            return super.getDefinition(name, tilesContext);
//            return tiles.get(name);
//        }
//        //        @Override
////        public Definition getDefinition(String name,
////                                        TilesRequestContext tilesContext) {
////            return tiles.get(name);
////        }
//    }

}
