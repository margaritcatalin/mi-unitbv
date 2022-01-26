package com.carstore.Warehouse.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carstore.CarStoreModel.dao.CarRepository;
import com.carstore.CarStoreModel.model.Car;
import com.carstore.Warehouse.service.CarService;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> findAll() {
        List<Car> carList = (List<Car>) carRepository.findAll();

        List<Car> activeCarList = carList.stream().filter(car -> car.isActive()).collect(Collectors.toList());

        /*for (Car car : carList) {
            if (car.isActive()) {
                activeCarList.add(car);
            }
        }*/

        return activeCarList;
    }

    public Car findOne(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public List<Car> blurrySearch(String keyword) {
        List<Car> carList = carRepository.findByNameContaining(keyword);

        List<Car> activeCarList = carList.stream().filter(car -> car.isActive()).collect(Collectors.toList());

      /*  for (Car car : carList) {
            if (car.isActive()) {
                activeCarList.add(car);
            }
        }*/

        return activeCarList;
    }

    public void removeOne(Long id) {
        carRepository.deleteById(id);
    }
}