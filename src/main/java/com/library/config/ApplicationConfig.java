package com.library.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by Dmytro on 8/7/2014.
 */
@Configuration
@ComponentScan(basePackages = "com.library")
@EnableMongoRepositories(basePackages = "com.library.repository")
@Import(MongoConfig.class)
public class ApplicationConfig {

}
