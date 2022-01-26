package com.carstore.billingservice.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carstore.CarStoreModel.dao.CarToCartItemRepository;
import com.carstore.CarStoreModel.dao.CartItemRepository;
import com.carstore.CarStoreModel.model.Car;
import com.carstore.CarStoreModel.model.CarToCartItem;
import com.carstore.CarStoreModel.model.CartItem;
import com.carstore.CarStoreModel.model.ShoppingCart;
import com.carstore.CarStoreModel.model.User;
import com.carstore.billingservice.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private CarToCartItemRepository carToCartItemRepository;

    public CartItem addCarToCartItem(Car car, User user, int qty) {
        List<CartItem> cartItemList = findByShoppingCart(user.getShoppingCart());

        for (CartItem cartItem : cartItemList) {
            if (car.getId() == cartItem.getCar().getId()) {
                cartItem.setQty(cartItem.getQty() + qty);
                cartItem.setSubtotal(new BigDecimal(car.getOurPrice()).multiply(new BigDecimal(qty)));
                cartItemRepository.save(cartItem);
                return cartItem;
            }
        }

        CartItem cartItem = new CartItem();
        cartItem.setShoppingCart(user.getShoppingCart());
        cartItem.setCar(car);
        cartItem.setQty(qty);
        cartItem.setSubtotal(new BigDecimal(car.getOurPrice()).multiply(new BigDecimal(qty)));

        cartItem = cartItemRepository.save(cartItem);

        CarToCartItem carToCartItem = new CarToCartItem();
        carToCartItem.setCar(car);
        carToCartItem.setCartItem(cartItem);
        carToCartItemRepository.save(carToCartItem);

        return cartItem;
    }

    @Transactional
    public void removeCartItem(CartItem cartItem) {
        carToCartItemRepository.deleteByCartItem(cartItem);
        cartItemRepository.delete(cartItem);
    }

    public List<CartItem> findByShoppingCart(ShoppingCart shoppingCart) {
        return cartItemRepository.findByShoppingCart(shoppingCart);
    }

    public CartItem updateCartItem(CartItem cartItem) {
        BigDecimal bigDecimal = new BigDecimal(cartItem.getCar().getOurPrice()).multiply(new BigDecimal(cartItem.getQty()));
        bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        cartItem.setSubtotal(bigDecimal);

        cartItemRepository.save(cartItem);

        return cartItem;

    }

    public CartItem findById(Long id) {
        return cartItemRepository.findById(id).orElse(null);
    }

    public CartItem save(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }
}
