package com.carstore.CarStoreModel.dao;

import org.springframework.data.repository.CrudRepository;

import com.carstore.CarStoreModel.model.CarToCartItem;
import com.carstore.CarStoreModel.model.CartItem;

public interface CarToCartItemRepository extends CrudRepository<CarToCartItem, Long> {
    void deleteByCartItem(CartItem cartItem);
}
