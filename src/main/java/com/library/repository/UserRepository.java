package com.library.repository;

import com.library.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Dmytro on 14.08.2014.
 */
public interface UserRepository extends CrudRepository<User, String> {
}
