package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CarType {

    @Id
    private int carType_id;
    private String car_type;
    private String transmission;
    private int eng_volume;
    private boolean air_con;
    private boolean cruise_control;
    private String seats;
    private int hp;

    public CarType(){}

    public CarType(int carType_id, String car_type, String transmission, int eng_volume, boolean air_con, boolean cruise_control, String seats, int hp) {
        this.carType_id = carType_id;
        this.car_type = car_type;
        this.transmission = transmission;
        this.eng_volume = eng_volume;
        this.air_con = air_con;
        this.cruise_control = cruise_control;
        this.seats = seats;
        this.hp = hp;
    }

    public int getCarType_id() {
        return carType_id;
    }

    public void setCarType_id(int carType_id) {
        this.carType_id = carType_id;
    }

    public String getCar_type() {
        return car_type;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getEng_volume() {
        return eng_volume;
    }

    public void setEng_volume(int eng_volume) {
        this.eng_volume = eng_volume;
    }

    public boolean isAir_con() {
        return air_con;
    }

    public void setAir_con(boolean air_con) {
        this.air_con = air_con;
    }

    public boolean isCruise_control() {
        return cruise_control;
    }

    public void setCruise_control(boolean cruise_control) {
        this.cruise_control = cruise_control;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
