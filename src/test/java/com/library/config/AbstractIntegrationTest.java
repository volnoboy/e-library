package com.library.config;

import com.library.SetAuthors;
import com.library.model.*;
import com.mongodb.DB;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by milgoff on 10.08.14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
public class AbstractIntegrationTest {

	@Autowired
	private MongoTemplate mongo;
	private SetAuthors<Author> set = new SetAuthors<Author>();
	private Book book;
	private User user;

	@Before
	public void setUp() {
		Author author = new Author("Matthew", "McConnel");
		Publisher publisher = new Publisher("Bloomsbury Publishing");
		set.add(author);
		book = new Book(set, publisher, "autobiography", "978-5");
		user = new User(UserType.USER, "name", "pass");
		long time = System.currentTimeMillis();
		Order order = new Order(user, book, Status.ACTIVE, new Date(time), new Date(time + 10000));
		mongo.insert(author);
		mongo.insert(publisher);
		mongo.insert(book);
		mongo.insert(user);
		mongo.insert(order);
	}

	@After
	public void deleteDB() {
		DB database = mongo.getDb();
		database.dropDatabase();
	}

	@Test
	public void AuthorTest() {
		Assert.assertEquals(1, mongo.findAll(Author.class).size());
		Assert.assertEquals("McConnel", mongo.find(new Query(Criteria.where("firstname").is("Matthew")), Author.class).get(0).getLastname());
		mongo.updateFirst(new Query(Criteria.where("firstname").is("Matthew")), Update.update("lastname", "Vasia"), Author.class);
		Assert.assertEquals("Vasia", mongo.find(new Query(Criteria.where("firstname").is("Matthew")), Author.class).get(0).getLastname());
		mongo.findAndRemove(new Query(Criteria.where("lastname").is("Vasia")), Author.class);
		Assert.assertEquals(0, mongo.findAll(Author.class).size());
	}

	@Test
	public void PublisherTest() {
		Assert.assertEquals(1, mongo.findAll(Publisher.class).size());
		Assert.assertEquals("Bloomsbury Publishing", mongo.find(new Query(Criteria.where("name").is("Bloomsbury Publishing")), Publisher.class).get(0).getName());
		mongo.updateFirst(new Query(Criteria.where("name").is("Bloomsbury Publishing")), Update.update("name", "Vasia"), Publisher.class);
		Assert.assertEquals("Vasia", mongo.find(new Query(Criteria.where("name").is("Vasia")), Publisher.class).get(0).getName());
		mongo.findAndRemove(new Query(Criteria.where("name").is("Vasia")), Publisher.class);
		Assert.assertEquals(0, mongo.findAll(Publisher.class).size());
	}

	@Test
	public void UserTest() {
		Assert.assertEquals(1, mongo.findAll(User.class).size());
		Assert.assertEquals(UserType.USER, mongo.find(new Query(Criteria.where("password").is("pass")), User.class).get(0).getUserType());
		Assert.assertEquals("name", mongo.find(new Query(Criteria.where("password").is("pass")), User.class).get(0).getLogin());
		Assert.assertEquals("pass", mongo.find(new Query(Criteria.where("userType").is("USER")), User.class).get(0).getPassword());
		mongo.updateFirst(new Query(Criteria.where("login").is("name")), Update.update("userType", UserType.LIBRARIAN), User.class);
		Assert.assertEquals(UserType.LIBRARIAN, mongo.find(new Query(Criteria.where("password").is("pass")), User.class).get(0).getUserType());
		mongo.findAndRemove(new Query(Criteria.where("userType").is("LIBRARIAN")), User.class);
		Assert.assertEquals(0, mongo.findAll(User.class).size());
	}

	@Test
	public void BookTest() {
		Assert.assertEquals(1, mongo.findAll(Book.class).size());
		Assert.assertEquals("978-5", mongo.find(new Query(Criteria.where("title").is("autobiography")), Book.class).get(0).getIsbn());
		Assert.assertEquals("autobiography", mongo.find(new Query(Criteria.where("ISBN").is("978-5")), Book.class).get(0).getTitle());
		Assert.assertEquals(1, mongo.find(new Query(Criteria.where("ISBN").is("978-5")), Book.class).get(0).getAuthors().size());
		Assert.assertEquals("McConnel", mongo.find(new Query(Criteria.where("ISBN").is("978-5")), Book.class).get(0).getAuthors().iterator().next().getLastname());
		set.add(new Author("David", "Flenagan"));
		mongo.updateFirst(new Query(Criteria.where("ISBN").is("978-5")), Update.update("authors", set), Book.class);
		Assert.assertEquals(2, mongo.find(new Query(Criteria.where("ISBN").is("978-5")), Book.class).get(0).getAuthors().size());
		mongo.findAndRemove(new Query(Criteria.where("ISBN").is("978-5")), Book.class);
		Assert.assertEquals(0, mongo.findAll(Book.class).size());
	}

	@Test
	public void OrderTest() {
		Assert.assertEquals(1, mongo.findAll(Order.class).size());
		Assert.assertEquals(user, mongo.find(new Query(Criteria.where("status").is(Status.ACTIVE)), Order.class).get(0).getUser());
		Assert.assertEquals(book, mongo.find(new Query(Criteria.where("user").is(user)), Order.class).get(0).getBook());
		Assert.assertEquals(1, mongo.find(new Query(Criteria.where("user").is(user)), Order.class).get(0).getBook().getAuthors().size());
		Assert.assertEquals("McConnel", mongo.find(new Query(Criteria.where("user").is(user)), Order.class).get(0).getBook().getAuthors().iterator().next().getLastname());
		mongo.updateFirst(new Query(Criteria.where("user").is(user)), Update.update("status", Status.IN_STOCK), Order.class);
		Assert.assertEquals(Status.IN_STOCK, mongo.find(new Query(Criteria.where("user").is(user)), Order.class).get(0).getStatus());
		mongo.findAndRemove(new Query(Criteria.where("status").is("IN_STOCK")), Order.class);
		Assert.assertEquals(0, mongo.findAll(Order.class).size());
	}
}
