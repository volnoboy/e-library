package com.library.repository;

import com.library.model.Author;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dmytro on 14.08.2014.
 */
//@Repository
public interface AuthorRepository extends PagingAndSortingRepository<Author, String> {
    List<Author> findByLastname(String lastname);

    List<Author> findByFirstname(String firstname);
}
