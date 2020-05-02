package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CarComplete {

    @Id
    private int car_id;
    private String brand;
    private String model;
    private String reg_num;
    private String reg_date;
    private int mileage;
    private String car_type;
    private String transmission;
    private String  air_con;
    private int eng_volume;
    private int hp;
    private String seats;

    public CarComplete() {}

    public CarComplete(int car_id, String brand, String model, String reg_num, String reg_date, int mileage, String car_type, String transmission, String air_con, int eng_volume, int hp, String seats) {
        this.car_id = car_id;
        this.brand = brand;
        this.model = model;
        this.reg_num = reg_num;
        this.reg_date = reg_date;
        this.mileage = mileage;
        this.car_type = car_type;
        this.transmission = transmission;
        this.air_con = air_con;

        this.eng_volume = eng_volume;
        this.hp = hp;
        this.seats = seats;
    }

    public void change_airCon(){
        if(air_con.equals("1")){
            air_con = "Yes";
        }else{
            air_con = "No";
        }
    }


    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public String getAir_con() {
        return air_con;
    }

    public void setAir_con(String air_con) {
        this.air_con = air_con;
    }

    public int getEng_volume() {
        return eng_volume;
    }

    public void setEng_volume(int eng_volume) {
        this.eng_volume = eng_volume;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }


}
