package com.library.config;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ApplicationConfigTest {

    @Test
    public void bootstrapAppFromXml() {

        ApplicationContext context = new GenericXmlApplicationContext("application-context.xml");
        assertThat(context, is(notNullValue()));
    }
}