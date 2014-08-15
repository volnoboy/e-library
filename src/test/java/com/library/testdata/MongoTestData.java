package com.library.testdata;

import com.library.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by Dmytro on 14.08.2014.
 */
@Component
public class MongoTestData {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void libraryTestData() {
        mongoTemplate.dropCollection(Author.class);

        Author africa = new Author("William", "Shakespeare");
        Author asia = new Author("Agatha", "Christie");
        Author europe = new Author("Barbara", "Cartland");
        Author northAmerica = new Author("Lev", "Tolstoy");
        Author southAmerica = new Author("Aleksei", "Miller");
        Author australia = new Author("Alexander", "Pushkin");
        Author antarctica = new Author("Aleksei", "Tolstoy");

        mongoTemplate.insert(africa);
        mongoTemplate.insert(asia);
        mongoTemplate.insert(europe);
        mongoTemplate.insert(northAmerica);
        mongoTemplate.insert(southAmerica);
        mongoTemplate.insert(australia);
        mongoTemplate.insert(antarctica);
    }
}
