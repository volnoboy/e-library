package com.library.repository;

import com.library.model.Author;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Dmytro on 14.08.2014.
 */
public interface AuthorRepository extends PagingAndSortingRepository<Author, String> {
}
