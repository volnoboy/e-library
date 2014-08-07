package com.library;

import com.library.model.Author;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by Dmytro on 8/7/2014.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class ApplicationConfig extends AbstractMongoConfiguration {
    public static void main(String[] args) {
        //For XML
        ApplicationContext ctx = new GenericXmlApplicationContext("META_INF/spring/application-context.xml");

        // For Annotation
//        ApplicationContext ctx =
//                new AnnotationConfigApplicationContext(SpringMongoConfig.class);
        MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

//
//        ApplicationContext ctx = new GenericXmlApplicationContext("application-context.xml");
//        MongoOperations mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate");

        Author author = new Author();
        author.setFirstName("Robert");
        author.setLastName("Slave");

        // save
        mongoOperation.save(author);

        // now user object got the created id.
        System.out.println("1. author : " + author);
    }

    @Override
    protected String getDatabaseName() {
        return "library ";
    }

    @Override
    public Mongo mongo() throws Exception {
        MongoClient client = new MongoClient("127.0.0.1:27017");
        client.setWriteConcern(WriteConcern.SAFE);
        return client;
    }


}
