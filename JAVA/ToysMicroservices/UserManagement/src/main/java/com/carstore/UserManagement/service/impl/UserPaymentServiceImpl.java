package com.carstore.UserManagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carstore.CarStoreModel.dao.UserPaymentRepository;
import com.carstore.CarStoreModel.model.UserPayment;
import com.carstore.UserManagement.service.UserPaymentService;

@Service
public class UserPaymentServiceImpl implements UserPaymentService {
    
    @Autowired
    private UserPaymentRepository userPaymentRepository;

    public UserPayment findById(Long id) {
        return userPaymentRepository.findById(id).orElse(null);
    }

    public void removeById(Long id) {
        userPaymentRepository.deleteById(id);
    }

}

