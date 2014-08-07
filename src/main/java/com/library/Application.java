package com.library;

import com.library.config.SpringMongoConfig;
import com.library.model.Author;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.Query;

/**
 * Created by Dmytro on 8/7/2014.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = SpringMongoConfig.class)
public class Application {
    public static void main(String[] args) {
        //For XML
//        ApplicationContext ctx = new GenericXmlApplicationContext("SpringConfig.xml");

        // For Annotation
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(SpringMongoConfig.class);
        MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

//
//        ApplicationContext ctx = new GenericXmlApplicationContext("SpringConfig.xml");
//        MongoOperations mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate");

        Author author = new Author();
        author.setFirstName("Robert");
        author.setLastName("Slave");

        // save
        mongoOperation.save(author);

        // now user object got the created id.
        System.out.println("1. author : " + author);

//        // query to search user
//        Query searchUserQuery = new Query(Criteria.where("firstName").is("Robert"));
//
//        // find the saved user again.
//        Author savedAuthor = mongoOperation.findOne(searchUserQuery, Author.class);
//        System.out.println("2. find - savedUser : " + savedUser);
//
//        // update password
//        mongoOperation.updateFirst(searchUserQuery,
//                Update.update("password", "new password"),User.class);
//
//        // find the updated user object
//        User updatedUser = mongoOperation.findOne(searchUserQuery, User.class);
//
//        System.out.println("3. updatedUser : " + updatedUser);
//
//        // delete
//        mongoOperation.remove(searchUserQuery, User.class);
//
//        // List, it should be empty now.
//        List<User> listUser = mongoOperation.findAll(User.class);
//        System.out.println("4. Number of user = " + listUser.size());
    }
}
