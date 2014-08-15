package com.library.repository;

import com.library.config.ApplicationConfig;
import com.library.model.Author;
import com.library.testdata.MongoTestData;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Created by Dmytro on 14.08.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private MongoTestData testData;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Before
    public void reset() {
        testData.libraryTestData();
    }

    @Test
    public void testFindByName() {
        List<Author> author = authorRepository.findByFirstname("William");
        assertEquals(author.size(), 1);
        assertEquals(author.get(0).getLastname(), "Shakespeare");
        assertEquals(author.get(0).getFirstname(), "William");
        author = authorRepository.findByLastname("Shakespeare");
        assertEquals(author.size(), 1);
        assertEquals(author.get(0).getLastname(), "Shakespeare");
        assertEquals(author.get(0).getFirstname(), "William");
    }

    @Test
    public void testSelect() {
        Author author = mongoTemplate.findOne(query(where("firstname").is("William")), Author.class);
        assertEquals(author.getFirstname(), "William");
//        assertThat(mongoOps.findById(BigInteger.valueOf(6), City.class).getName(), equalTo("Chicago"));
    }

}
