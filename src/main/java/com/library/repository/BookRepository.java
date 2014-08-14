package com.library.repository;

import com.library.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Dmytro on 14.08.2014.
 */
public interface BookRepository extends PagingAndSortingRepository<Book, String> {
}
