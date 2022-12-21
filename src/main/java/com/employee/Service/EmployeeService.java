package com.employee.Service;

import com.employee.Entity.EmployeeEntity;
import com.employee.Model.EmployeeModel;
import com.employee.Repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private ModelMapper modelMapper;
    private EmployeeRepository employeeRepository;
    public EmployeeService(ModelMapper modelMapper, EmployeeRepository employeeRepository){
        this.modelMapper=modelMapper;
        this.employeeRepository=employeeRepository;
    }
    public void create(EmployeeModel employeeModel) {

        EmployeeEntity employee = modelMapper.map(employeeModel, EmployeeEntity.class);
        employeeRepository.save(employee);

    }

    public List<EmployeeModel> getAll() {

        List<EmployeeEntity> employees = employeeRepository.findAll();
        List<EmployeeModel> employeeList = Arrays.asList(modelMapper.map(employees, EmployeeModel[].class));
        return employeeList;
    }

    public EmployeeModel getById(long id) {

        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
        EmployeeModel employee = modelMapper.map(employeeEntity, EmployeeModel.class);
        return employee;
    }

    public EmployeeModel update(long id, EmployeeModel employeeModel) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
        employeeEntity.ifPresentOrElse(value -> employeeRepository.save(value),
                () -> System.out.println("Employee not found"));

        EmployeeModel emp = modelMapper.map(employeeEntity.get(), EmployeeModel.class);
        return emp;
    }

    public void delete(EmployeeModel employeeModel) {
        EmployeeEntity emp = modelMapper.map(employeeModel, EmployeeEntity.class);
        employeeRepository.delete(emp);
    }
}
