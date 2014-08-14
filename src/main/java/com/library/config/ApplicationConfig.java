package com.library.config;

import org.springframework.context.annotation.*;

/**
 * Created by Dmytro on 8/7/2014.
 */
@Configuration
@ComponentScan(basePackages = "com.library")
//@EnableAutoConfiguration
//@EnableMongoRepositories
@Import(MongoConfig.class)
public class ApplicationConfig {
}
