package com.library.repository;

import com.library.model.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dmytro on 14.08.2014.
 */
@Repository
public interface PublisherRepository extends CrudRepository<Publisher,String> {

	List<Publisher> findAll();

	Publisher findByName(String name);
}
