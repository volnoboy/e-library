package com.library.repository;

import com.library.config.ApplicationConfig;
import com.library.model.Publisher;
import com.mongodb.DB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by alitvin on 8/15/2014.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
public class PublisherRepositoryTest {

	@Autowired
	private PublisherRepository publisherRepository;
	@Autowired
	private MongoTemplate       mongo;

	Publisher p = new Publisher("Ardis Publishing");

	@Before
	public void setUp() {
		DB database = mongo.getDb();
		database.dropDatabase();
		mongo.insert(p);
		mongo.insert(new Publisher("Bloomsbury Publishing"));
		mongo.insert(new Publisher("3D Realms"));
	}

	@Test
	public void publisherRepositoryTest() {
		Assert.assertEquals(3, publisherRepository.count());
		Assert.assertTrue(publisherRepository.exists(p.getObjectId()));
		Assert.assertTrue(publisherRepository.findAll().iterator().hasNext());
		Assert.assertEquals(p, publisherRepository.findOne(p.getObjectId()));
		publisherRepository.save(new Publisher("3D"));
		Assert.assertEquals(4, publisherRepository.count());
		publisherRepository.delete(p.getObjectId());
		Assert.assertEquals(3, publisherRepository.count());
		publisherRepository.deleteAll();
		Assert.assertEquals(0, publisherRepository.count());
	}
}
