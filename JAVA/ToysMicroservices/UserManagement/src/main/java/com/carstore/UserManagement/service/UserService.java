package com.carstore.UserManagement.service;

import java.util.Set;

import com.carstore.CarStoreModel.model.User;
import com.carstore.CarStoreModel.model.UserBilling;
import com.carstore.CarStoreModel.model.UserPayment;
import com.carstore.CarStoreModel.model.UserRole;
import com.carstore.CarStoreModel.model.UserShipping;

public interface UserService {

    User createUser(User user, Set<UserRole> userRoles);

    User save(User user);

    User findByUsername(String username);

    User findByEmail(String email);

    User findById(Long id);

    void updateUserPaymentInfo(UserBilling userBilling, UserPayment userPayment, User user);

    void updateUserBilling(UserBilling userBilling, UserPayment userPayment, User user);

    void setUserDefaultPayment(Long userPaymentId, User user);

    void updateUserShipping(UserShipping userShipping, User user);

    void setUserDefaultShipping(Long userShippingId, User user);

}
