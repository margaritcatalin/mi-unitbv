package com.carstore.UserManagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carstore.CarStoreModel.dao.UserShippingRepository;
import com.carstore.CarStoreModel.model.UserShipping;
import com.carstore.UserManagement.service.UserShippingService;


@Service
public class UserShippingServiceImpl implements UserShippingService {

    @Autowired
    private UserShippingRepository userShippingRepository;

    public UserShipping findById(Long id) {
        return userShippingRepository.findById(id).orElse(null);
    }

    public void removeById(Long id) {
        userShippingRepository.deleteById(id);
    }
}
