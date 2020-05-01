package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CarModel {

    @Id
    private int brandModel_id;
    private String brand;
    private String model;

    public CarModel(){}

    public CarModel(int brandModel_id, String brand, String model) {
        this.brandModel_id = brandModel_id;
        this.brand = brand;
        this.model = model;
    }

    public int getBrandModel_id() {
        return brandModel_id;
    }

    public void setBrandModel_id(int brandModel_id) {
        this.brandModel_id = brandModel_id;
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
}
