package com.library.config;

import com.library.repository.RepositoryPackage;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;

/**
 * Created by Dmytro on 8/7/2014.
 */
@Configuration
@ComponentScan(basePackages = "com.library")
//@EnableAutoConfiguration
@EnableMongoRepositories(basePackages = "com.library.repository")
@Import(MongoConfig.class)
public class ApplicationConfig {


    @Value("${mongo.db}")
    private String mongoDatabase;
    @Value("${mongo.host}")
    private String mongoHostname;
    @Value("${mongo.port}")
    private String mongoPort;
    @Value("${mongo.username}")
    private String username;
    @Value("${mongo.password}")
    private String password;

    public
    @Bean
    MongoDbFactory mongoDbFactory() throws Exception {
        MongoCredential credential = MongoCredential.createMongoCRCredential(username, mongoDatabase, password.toCharArray());
        MongoClient mongo = new MongoClient(new ServerAddress(mongoHostname, Integer.parseInt(mongoPort)), Arrays.asList(credential));
        return new SimpleMongoDbFactory(mongo, mongoDatabase);

    }

    public
    @Bean
    MongoTemplate mongoTemplate() throws Exception {

        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        mongoTemplate.setWriteConcern(WriteConcern.SAFE);

        return mongoTemplate;

    }


}
