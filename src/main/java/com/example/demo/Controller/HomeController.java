package com.example.demo.Controller;

import com.example.demo.Model.Car;
import com.example.demo.Model.Contract;
import com.example.demo.Model.Customer;
import com.example.demo.Service.CarService;
import com.example.demo.Service.ContractService;
import com.example.demo.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    // ---- CARS ----

    @Autowired
    CarService carService;

    @GetMapping("/")
    public String index(){
        return "home/index";
    }

    @GetMapping("/createCar")
    public String createCar(){return "home/createCar"; }

    @PostMapping("/createCar")
    public String createCar(@ModelAttribute Car car){
        carService.addCar(car);
        return "redirect:/carMenu";
    }

    @GetMapping("/carMenu")
    public String carMenu(Model model){
        List<Car> carList = carService.fetchAll();
        model.addAttribute("cars", carList);
        return "home/carMenu";
    }

    @GetMapping("/viewCar/{car_id}")
    public String viewCar(@PathVariable("car_id") int car_id, Model model){
        model.addAttribute("carComplete", carService.findCarCompleteInfoById(car_id));
        return "home/viewCar";
    }

    @GetMapping("/deleteCar/{car_id}")
    public String deleteCar(@PathVariable("car_id") int car_id, Model model){
         boolean deleted = carService.deleteCar(car_id);
         if (deleted){
             return "redirect:/carMenu";
         }else{
             return "redirect:/carMenu";
         }

    }

    @GetMapping("/updateCar/{car_id}")
    public String updateCar(@PathVariable("car_id") int car_id, Model model){
        model.addAttribute("car", carService.findCarById(car_id));
        return"home/updateCar";
    }

    @PostMapping("/updateCar")
    public String updateCar(@ModelAttribute Car car){
        carService.updateCar(car.getCar_id(),  car);
        return "redirect:/carMenu";
    }


    // ---- CUSTOMERS ----

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public String customers(Model model){
        List<Customer> customerList = customerService.fetchAll();
        model.addAttribute("customers", customerList);
        return "home/customers";
    }

    @GetMapping("/add_customer")
    public String add_customer(){
        return "/home/add_customer";
    }

    @PostMapping("/add_customer")
    public String add_customer(@ModelAttribute Customer customer){
        customerService.addCustomer(customer);
        return "redirect:customers";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        boolean deleted = customerService.deleteCustomer(id);
        if (deleted) {
            return "redirect:/customers";
        }
        return "redirect:/customers";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model) {
        model.addAttribute("customer", customerService.findCustomerById(id));
        return "/home/update_customer";
    }
    @PostMapping("/updateCustomer")
    public String updateCustomer(@ModelAttribute Customer customer){
        customerService.updateCustomer(customer.getCustomer_id(), customer);
        return "redirect:customers";
    }

    //CONTRACTS
    @Autowired
    ContractService contractService;

    @GetMapping("/contracts")
    public String contracts(Model model){
        List<Contract> contractList = contractService.fetchAll();
        model.addAttribute("contracts", contractList);
        return "home/contracts";
    }

    @GetMapping("/add_contract")
    public String add_contract(){
        return "/home/add_contract";
    }

    @PostMapping("/add_contract")
    public String add_contract(@ModelAttribute Contract contract){
        contractService.addContract(contract);
        return "redirect:contracts";
    }

    @GetMapping("/deleteContract/{id}")
    public String deleteContract(@PathVariable("id") int id){
        boolean deleted = contractService.deleteContract(id);
        if (deleted) {
            return "redirect:/contracts";
        }
        return "redirect:/contracts";
    }

    @GetMapping("/updateContract/{id}")
    public String updateContract(@PathVariable("id") int id, Model model) {
        model.addAttribute("contract", contractService.findContractById(id));
        return "/home/update_contract";
    }
    @PostMapping("/updateContract")
    public String updateContract(@ModelAttribute Contract contract){
        contractService.updateContract(contract.getContract_id(), contract);
        return "redirect:contracts";
    }

}
