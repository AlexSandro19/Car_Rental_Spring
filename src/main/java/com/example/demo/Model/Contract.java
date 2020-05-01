package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Contract {

    @Id
    private int contract_id;
    private int renter_id;
    private int car_id;
    private String start_date;
    private String end_date;
    private int max_km;
    private int start_km;

    public Contract(){}

    public Contract(int contract_id, int renter_id, int car_id, String start_date, String end_date, int max_km, int start_km) {
        this.contract_id = contract_id;
        this.renter_id = renter_id;
        this.car_id = car_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.max_km = max_km;
        this.start_km = start_km;
    }

    public int getContract_id() {
        return contract_id;
    }

    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    public int getRenter_id() {
        return renter_id;
    }

    public void setRenter_id(int renter_id) {
        this.renter_id = renter_id;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public int getMax_km() {
        return max_km;
    }

    public void setMax_km(int max_km) {
        this.max_km = max_km;
    }

    public int getStart_km() {
        return start_km;
    }

    public void setStart_km(int start_km) {
        this.start_km = start_km;
    }
}
