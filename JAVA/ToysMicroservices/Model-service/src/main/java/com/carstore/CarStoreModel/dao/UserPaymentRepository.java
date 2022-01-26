package com.carstore.CarStoreModel.dao;

import org.springframework.data.repository.CrudRepository;

import com.carstore.CarStoreModel.model.UserPayment;

public interface UserPaymentRepository extends CrudRepository<UserPayment, Long> {

}
