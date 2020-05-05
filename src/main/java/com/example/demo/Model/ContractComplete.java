package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ContractComplete {

    @Id
    private int contract_id;
    private String first_name;
    private String last_name;
    private String driver_license;
    private String reg_num;
    private String start_date;
    private String end_date;
    private int max_km;
    private int start_km;

    public ContractComplete() {}

    public ContractComplete(int contract_id, String first_name, String last_name, String driver_license, String reg_num, String start_date, String end_date, int max_km, int start_km) {
        this.contract_id = contract_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.driver_license = driver_license;
        this.reg_num = reg_num;
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

    public String getDriver_license() {
        return driver_license;
    }

    public void setDriver_license(String driver_license) {
        this.driver_license = driver_license;
    }

    public String getReg_num() {
        return reg_num;
    }

    public void setReg_num(String reg_num) {
        this.reg_num = reg_num;
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
