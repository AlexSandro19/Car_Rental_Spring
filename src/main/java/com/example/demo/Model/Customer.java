package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    private int customer_id;
    private String first_name;
    private String last_name;
    private String st_address;
    private int zip;
    private String mobile_phone;
    private String addit_phone;
    private String email;
    private String driver_license;
    private String driver_since;

    public Customer(){}

    public Customer(int customer_id, String first_name, String last_name, String st_address, int zip, String mobile_phone, String addit_phone, String email, String driver_license, String driver_since) {
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.st_address = st_address;
        this.zip = zip;
        this.mobile_phone = mobile_phone;
        this.addit_phone = addit_phone;
        this.email = email;
        this.driver_license = driver_license;
        this.driver_since = driver_since;
    }


    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getSt_address() {
        return st_address;
    }

    public void setSt_address(String st_address) {
        this.st_address = st_address;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getAddit_phone() {
        return addit_phone;
    }

    public void setAddit_phone(String addit_phone) {
        this.addit_phone = addit_phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDriver_license() {
        return driver_license;
    }

    public void setDriver_license(String driver_license) {
        this.driver_license = driver_license;
    }

    public String getDriver_since() {
        return driver_since;
    }

    public void setDriver_since(String driver_since) {
        this.driver_since = driver_since;
    }
}
