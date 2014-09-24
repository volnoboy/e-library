package com.library.repository;

import com.library.model.Author;
import com.library.model.Book;
import com.library.model.Publisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dmytro on 14.08.2014.
 */
@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, String> {
	List<Book> findByTitle(String title);

	List<Book> findByAuthors(String authors);

	List<Book> findByAuthors(Author authors);

	Page<Book> findByTitle(String title,Pageable pageable);

	Page<Book> findByAuthors(Author authors ,Pageable pageable);

	Page<Book> findByTitleOrIsbn(String title, String isbn, Pageable pageable);
}
