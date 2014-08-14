package com.library.config;

import org.springframework.context.annotation.*;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by Dmytro on 8/7/2014.
 */
@Configuration
@ComponentScan(basePackages = "com.library")
@EnableMongoRepositories
@Import(MongoConfig.class)
public class ApplicationConfig {
}
