package com.carstore.Warehouse.service;

import java.util.List;

import com.carstore.CarStoreModel.model.Car;

public interface CarService {

    List<Car> findAll();

    Car findOne(Long id);

    Car save(Car car);

    List<Car> blurrySearch(String name);

    void removeOne(Long id);
}