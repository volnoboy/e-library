package com.library.repository;

import com.library.model.Order;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Dmytro on 14.08.2014.
 */
public interface OrderRepository extends PagingAndSortingRepository<Order, String> {
}
