package com.library.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 * Created by Dmytro on 8/7/2014.
 */
//@Configuration
//public class SpringMongoConfig /*extends AbstractMongoConfiguration */{
//
//    public
//    @Bean
//    MongoDbFactory mongoDbFactory() throws Exception {
//        return new SimpleMongoDbFactory(new MongoClient(), "library");
//    }
////
////    @Override
////    protected String getDatabaseName() {
////        return "library";
////    }
////
////    @Override
////    @Bean
////    public Mongo mongo() throws Exception {
////        MongoClient client = new MongoClient("127.0.0.1:27017");
////        client.setWriteConcern(WriteConcern.SAFE);
////        return client;
////    }
//
//    public
//    @Bean
//    MongoTemplate mongoTemplate() throws Exception {
//
//        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
//
//        return mongoTemplate;
//
//    }
//
//}
/**
 * Spring MongoDB configuration file
 *
 */
//@Configuration
public class SpringMongoConfig{

//    public @Bean
//    MongoTemplate mongoTemplate() throws Exception {
//
//        MongoTemplate mongoTemplate =
//                new MongoTemplate(new MongoClient("127.0.0.1", 27017),"names");
//        System.out.println("testtesttest");
//        return mongoTemplate;
//
//    }

}