package com.carstore.billingservice.service;

import com.carstore.CarStoreModel.model.BillingAddress;
import com.carstore.CarStoreModel.model.Order;
import com.carstore.CarStoreModel.model.Payment;
import com.carstore.CarStoreModel.model.ShippingAddress;
import com.carstore.CarStoreModel.model.ShoppingCart;
import com.carstore.CarStoreModel.model.User;

public interface OrderService {

    Order createOrder(
            ShoppingCart shoppingCart,
            ShippingAddress shippingAddress,
            BillingAddress billingAddress,
            Payment payment,
            String shippingMethod,
            User user
    );

}
