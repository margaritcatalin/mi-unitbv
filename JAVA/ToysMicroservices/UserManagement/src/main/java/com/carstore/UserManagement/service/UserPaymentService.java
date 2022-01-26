package com.carstore.UserManagement.service;

import com.carstore.CarStoreModel.model.UserPayment;

public interface UserPaymentService {

    UserPayment findById(Long id);

    void removeById(Long id);
}
