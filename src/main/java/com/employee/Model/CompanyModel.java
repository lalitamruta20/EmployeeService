package com.employee.Model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CompanyModel {

    private long id;

    @NotBlank(message = "Company Name is mandatory")
    private String name;
}
