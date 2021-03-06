package com.example.demo.Repository;


import com.example.demo.Model.Contract;
import com.example.demo.Model.ContractComplete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContractRepo {
    @Autowired
    JdbcTemplate template;

    public List<Contract> fetchAll(){
        String sql = "SELECT * FROM contracts;";
        RowMapper<Contract> rowMapper = new BeanPropertyRowMapper<>(Contract.class);
        return template.query(sql, rowMapper);
    }

    public Contract addContract(Contract c){
        String sql="INSERT INTO contracts (renter_id, car_id, start_date, end_date, max_km, start_km) VALUES (?, ?, ?, ?, ?, ?)";
        template.update(sql, c.getRenter_id(), c.getCar_id(), c.getStart_date(), c.getEnd_date(), c.getMax_km(), c.getStart_km());
        return null;
    }

    public Contract findContractById(int id){
        String sql = "SELECT * FROM contracts WHERE contract_id = ?;";
        RowMapper<Contract> rowMapper = new BeanPropertyRowMapper<>(Contract.class);
        Contract c = template.queryForObject(sql, rowMapper, id);
        return c;
    }

    public ContractComplete findContractCompleteInfoById(int id){
        String sql = "SELECT contracts.contract_id,customers.first_name,customers.last_name,customers.driver_license,cars.reg_num,contracts.start_date,contracts.end_date,contracts.max_km,contracts.start_km\n" +
                "FROM contracts\n" +
                "JOIN\n" +
                "customers ON customers.customer_id = contracts.renter_id\n" +
                "JOIN \n" +
                "cars ON cars.car_id = contracts.car_id\n" +
                "WHERE contract_id = ?;";
        RowMapper<ContractComplete> rowMapper = new BeanPropertyRowMapper<>(ContractComplete.class);
        ContractComplete contractComplete = template.queryForObject(sql, rowMapper, id);
        return contractComplete;
    }

    public Boolean deleteContract(int id){
        String sql = "DELETE FROM contracts WHERE contract_id = ?";
        return template.update(sql, id) < 0;
    }

    public Contract updateContract(int id, Contract c){
        String sql = "UPDATE contracts SET  renter_id = ?, car_id = ?, start_date = ?, end_date = ?, max_km = ?, start_km = ? WHERE contract_id = ?";
        template.update(sql, c.getRenter_id(), c.getCar_id(), c.getStart_date(), c.getEnd_date(), c.getMax_km(), c.getStart_km(), c.getContract_id());
        return null;
    }


}
