package com.employee.Service;

import com.employee.Entity.CompanyEntity;
import com.employee.Model.CompanyModel;
import com.employee.Repository.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private CompanyRepository companyRepository;
    private ModelMapper modelMapper;

    public CompanyService(CompanyRepository companyRepository, ModelMapper modelMapper){
        this.companyRepository = companyRepository;
        this.modelMapper = modelMapper;
    }
    public void create(CompanyModel companyModel) {
        CompanyEntity companyEntity = modelMapper.map(companyModel,CompanyEntity.class);
        companyRepository.save(companyEntity);
    }
}
