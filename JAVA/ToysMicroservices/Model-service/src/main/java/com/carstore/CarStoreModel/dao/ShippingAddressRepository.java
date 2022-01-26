package com.carstore.CarStoreModel.dao;

import org.springframework.data.repository.CrudRepository;

import com.carstore.CarStoreModel.model.ShippingAddress;

public interface ShippingAddressRepository extends CrudRepository<ShippingAddress, Long> {

}
