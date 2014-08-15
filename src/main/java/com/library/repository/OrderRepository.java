package com.library.repository;

import com.library.model.Order;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Dmytro on 14.08.2014.
 */
@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order, String> {
}
