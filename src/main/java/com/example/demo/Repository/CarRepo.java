package com.example.demo.Repository;

import com.example.demo.Model.Car;
import com.example.demo.Model.CarComplete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepo {

    @Autowired
    JdbcTemplate template;

    public List<Car> fetchAll(){
        String sql = "SELECT * FROM cars;";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
        return template.query(sql, rowMapper);
    }

    public Car addCar(Car car){

        return null;
    }

    public CarComplete findCarById(int id){
        String sql = "SELECT cars.car_id,brandmodels.brand,\n" +
                "brandmodels.model,cars.reg_num,cars.reg_date,cars.mileage,\n" +
                "cartypes.car_type, cartypes.transmission,cartypes.air_con,cartypes.eng_volume,\n" +
                "cartypes.hp,cartypes.seats\n" +
                "FROM cars \n" +
                "JOIN cartypes ON cartypes.carType_id = cars.carType_id\n" +
                "JOIN brandmodels ON cars.brandModel_id = brandmodels.brandModel_id\n" +
                "WHERE cars.car_id = ?;";
        RowMapper<CarComplete> rowMapper = new BeanPropertyRowMapper<>(CarComplete.class);
        CarComplete carComplete = template.queryForObject(sql, rowMapper, id);
        carComplete.change_airCon();
        return carComplete;
    }

    public Boolean deleteCar(int id){
        return null;
    }

    public Car updateCar(int id, Car car){
        return null;
    }
}
