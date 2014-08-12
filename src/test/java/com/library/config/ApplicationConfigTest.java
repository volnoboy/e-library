package com.library.config;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by alitvin on 8/11/2014.
 */
public class ApplicationConfigTest {

	@Test
	public void bootstrapAppFromJavaConfig() {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		assertThat(context, is(notNullValue()));
		MongoDbFactory mongoDbFactory = (MongoDbFactory) context.getBean("mongoDbFactory");
		Assert.assertEquals("libraryTest", mongoDbFactory.getDb().getName());
		MongoTemplate mongoTemplate = (MongoTemplate) context.getBean("mongoTemplate");
		assertThat(mongoTemplate, is(notNullValue()));
	}
}
