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
        String sql = "INSERT INTO cars (brandModel_id, reg_num, reg_date, mileage, carType_id)" +
                        "VALUES (?, ?, ?, ?, ?);";
        template.update(sql, car.getBrandModel_id(), car.getReg_num(), car.getReg_date(),
                        car.getMileage(), car.getCarType_id());
        return null;
    }

    public Car findCarById(int id){
        String sql = "SELECT * FROM cars WHERE cars.car_id = ?;";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
        Car car = template.queryForObject(sql, rowMapper, id);
        return car;
    }
    public CarComplete findCarCompleteInfoById(int id){
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
        String sql = "DELETE FROM cars WHERE car_id = ?;";
        return template.update(sql, id) < 0;

    }

    public Car updateCar(int id, Car car){
        String sql = "UPDATE cars SET brandModel_id = ?, reg_num = ?, reg_date = ?, mileage = ?, carType_id = ? " +
                     "WHERE car_id = ?;";
        template.update(sql, car.getBrandModel_id(), car.getReg_num(), car.getReg_date(),
                             car.getMileage(), car.getCarType_id(), id);
        return null;
    }
}
