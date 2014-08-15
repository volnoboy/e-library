package com.library.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.util.Arrays;

@Configuration
@PropertySource("classpath:mongo.properties")
public class MongoConfig {

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


    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}