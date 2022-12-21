package com.employee.Repository;

import com.employee.Entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<CompanyEntity,Long> {
}
