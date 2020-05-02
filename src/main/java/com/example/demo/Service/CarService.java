package com.example.demo.Service;

import com.example.demo.Model.Car;
import com.example.demo.Model.CarComplete;
import com.example.demo.Repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepo carRepo;

    public List<Car> fetchAll(){
        return carRepo.fetchAll();
    }

    public Car addCar(Car car){
        return carRepo.addCar(car);
    }

    public CarComplete findCarById(int id){
        return carRepo.findCarById(id);
    }

    public Boolean deleteCar(int id){
        return carRepo.deleteCar(id);
    }

    public Car updateCar(int id, Car car){
        return carRepo.updateCar(id, car);
    }
}
