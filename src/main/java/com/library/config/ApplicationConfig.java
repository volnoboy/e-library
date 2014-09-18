package com.library.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Dmytro on 8/7/2014.
 */
@Configuration
@ComponentScan(ApplicationConfig.BASE_PACKAGE)
@EnableAutoConfiguration
@Import({MongoConfig.class, MvcConfig.class, TilesConfig.class})
public class ApplicationConfig {
    static final String BASE_PACKAGE = "com.library";
}
