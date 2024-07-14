package com.example.PlooxaCompanyAndEmployee.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PlooxaCompanyAndEmployee.Model.CompanyAndIdAndCompanyName;
@Repository
public interface CompanyAndIdAndCompanyNameRepository extends JpaRepository<CompanyAndIdAndCompanyName, Long>{
    
    List<CompanyAndIdAndCompanyName> findByCompanyName(String companyName,double mobileName,String address,String unikCode);
}
