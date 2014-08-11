package com.library.config;

import com.mongodb.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by milgoff on 10.08.14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
/*abstract*/ public class AbstractIntegrationTest {

    @Autowired
    MongoTemplate mongo;

    @Test
    public void setUp() {
        DB database = mongo.getDb();
//// Customers
        DBCollection authors = database.getCollection("author");
        authors.drop();
        DBObject dave = new BasicDBObject("firstname", "Dave");
        dave.put("firstname", "Matthew");
        dave.put("lastname", "McConnel");
        authors.insert(dave);
//// Products
//        DBCollection products = database.getCollection("product");
//        products.drop();
//        DBObject iPad = new BasicDBObject("name", "iPad");
//        iPad.put("description", "Apple tablet device");
//        iPad.put("price", 499.0);
//        iPad.put("attributes", new BasicDBObject("connector", "plug"));
//        DBObject macBook = new BasicDBObject("name", "MacBook Pro");
//        macBook.put("description", "Apple notebook");
//        macBook.put("price", 1299.0);
//        BasicDBObject dock = new BasicDBObject("name", "Dock");
//        dock.put("description", "Dock for iPhone/iPad");
//        dock.put("price", 49.0);
//        dock.put("attributes", new BasicDBObject("connector", "plug"));
//        products.insert(iPad, macBook, dock);
//// Orders
//        DBCollection orders = database.getCollection("order");
//        orders.drop();
//// Line items
//        DBObject iPadLineItem = new BasicDBObject("product", iPad);
//        iPadLineItem.put("amount", 2);
//        DBObject macBookLineItem = new BasicDBObject("product", macBook);
//        macBookLineItem.put("amount", 1);
//        BasicDBList lineItems = new BasicDBList();
//        lineItems.add(iPadLineItem);
//        lineItems.add(macBookLineItem);
//        DBObject order = new BasicDBObject("customer", new DBRef(database, "customer", dave.get("_id")));
//        order.put("lineItems", lineItems);
//        order.put("shippingAddress", address);
//        orders.insert(order);
    }
}
