package com.library.repository;

import com.library.model.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Dmytro on 14.08.2014.
 */
@Repository
public interface PublisherRepository extends CrudRepository<Publisher, String> {
}
