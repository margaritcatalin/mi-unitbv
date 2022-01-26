package com.carstore.CarStoreModel.dao;

import org.springframework.data.repository.CrudRepository;

import com.carstore.CarStoreModel.model.Order;
import com.carstore.CarStoreModel.model.User;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findByUser(User user);
}
