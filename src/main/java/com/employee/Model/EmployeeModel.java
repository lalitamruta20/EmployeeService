package com.employee.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmployeeModel {

    private long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    private String surname;

    @Email
    @NotBlank(message = "Email is mandatory")
    private String email;

    private String address;

    @NotBlank(message = "Salary is mandatory")
    private long salary;

    @NotBlank(message = "CompanyId is mandatory")
    private long companyId;
}
