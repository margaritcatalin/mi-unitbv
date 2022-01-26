package com.carstore.UserManagement.service;

import com.carstore.CarStoreModel.model.UserShipping;

public interface UserShippingService {

    UserShipping findById(Long id);

    void removeById(Long id);

}
