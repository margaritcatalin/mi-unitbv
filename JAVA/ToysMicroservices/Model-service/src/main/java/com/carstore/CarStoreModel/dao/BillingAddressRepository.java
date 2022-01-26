package com.carstore.CarStoreModel.dao;

import org.springframework.data.repository.CrudRepository;

import com.carstore.CarStoreModel.model.BillingAddress;

public interface BillingAddressRepository extends CrudRepository<BillingAddress, Long> {

}
