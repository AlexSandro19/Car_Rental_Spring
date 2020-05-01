package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {

    @Id
    private int car_id;
    private int brandModel_id;
    private String reg_num;
    private String reg_date;
    private int mileage;
    private int carType_id;

    public Car(){}

    public Car(int car_id, int brandModel_id, String reg_num, String reg_date, int mileage, int carType_id) {
        this.car_id = car_id;
        this.brandModel_id = brandModel_id;
        this.reg_num = reg_num;
        this.reg_date = reg_date;
        this.mileage = mileage;
        this.carType_id = carType_id;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public int getBrandModel_id() {
        return brandModel_id;
    }

    public void setBrandModel_id(int brandModel_id) {
        this.brandModel_id = brandModel_id;
    }

    public String getReg_num() {
        return reg_num;
    }

    public void setReg_num(String reg_num) {
        this.reg_num = reg_num;
    }

    public String getReg_date() {
        return reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getCarType_id() {
        return carType_id;
    }

    public void setCarType_id(int carType_id) {
        this.carType_id = carType_id;
    }
}
