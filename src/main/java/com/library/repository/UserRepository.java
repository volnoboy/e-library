package com.library.repository;

import com.library.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Dmytro on 14.08.2014.
 */
@Repository
public interface UserRepository extends CrudRepository<User, String> {
}
