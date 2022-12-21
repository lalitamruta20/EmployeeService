package com.employee.controller;

import com.employee.Model.EmployeeModel;
import com.employee.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {


    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping("/employee")
    public void create(@Valid @RequestBody EmployeeModel employeeModel){
        employeeService.create(employeeModel);

    }
    @GetMapping("/employees")
    public List<EmployeeModel> getAll(){
        return employeeService.getAll();
    }

    @GetMapping("/employee/{id}")
    public EmployeeModel getById(@PathVariable long id){
        return employeeService.getById(id);
    }

    @PutMapping("/employee/{id}")
    public EmployeeModel update(@PathVariable long id, @RequestBody EmployeeModel employeeModel){
        return employeeService.update(id, employeeModel);
    }

    @DeleteMapping("/employee/{id}")
    public void delete(@RequestBody EmployeeModel employeeModel){

        employeeService.delete(employeeModel);
    }
}
