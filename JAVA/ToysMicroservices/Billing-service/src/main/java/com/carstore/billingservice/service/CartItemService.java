package com.carstore.billingservice.service;

import java.util.List;

import com.carstore.CarStoreModel.model.Car;
import com.carstore.CarStoreModel.model.CartItem;
import com.carstore.CarStoreModel.model.ShoppingCart;
import com.carstore.CarStoreModel.model.User;

public interface CartItemService {

    CartItem addCarToCartItem(Car car, User user, int qty);

    List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);

    CartItem updateCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    CartItem findById(Long id);

    CartItem save(CartItem cartItem);

}
