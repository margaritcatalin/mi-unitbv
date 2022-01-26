package com.carstore.CarStoreModel.dao;

import org.springframework.data.repository.CrudRepository;

import com.carstore.CarStoreModel.model.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

}
