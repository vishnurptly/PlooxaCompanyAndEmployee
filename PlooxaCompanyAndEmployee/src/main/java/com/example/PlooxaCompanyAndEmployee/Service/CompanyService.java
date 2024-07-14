package com.example.PlooxaCompanyAndEmployee.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PlooxaCompanyAndEmployee.Mapper.companyMapper;
import com.example.PlooxaCompanyAndEmployee.Model.CompanyAndIdAndCompanyName;
import com.example.PlooxaCompanyAndEmployee.Repository.CompanyAndIdAndCompanyNameRepository;

import jakarta.transaction.Transactional;

@Service
public class CompanyService {

    @Autowired
    private CompanyAndIdAndCompanyNameRepository companyAndIdAndCompanyNameRepository;

    

    @Autowired
    private companyMapper CompanyMapper;

    @Transactional
    private CompanyAndIdAndCompanyName save(CompanyAndIdAndCompanyName companyAndIdAndCompanyName){
        companyAndIdAndCompanyNameRepository.save(companyAndIdAndCompanyName);
        return companyAndIdAndCompanyName;
    }

    public List<CompanyAndIdAndCompanyName> getAllProducts() {
        return companyAndIdAndCompanyNameRepository.findAll();
    }

    public CompanyAndIdAndCompanyName getProductById(Long id) {
        return companyAndIdAndCompanyNameRepository.findById(id).orElse(null);
    }

    public CompanyAndIdAndCompanyName createProduct(CompanyAndIdAndCompanyName product) {
        return companyAndIdAndCompanyNameRepository.save(product);
    }

    public CompanyAndIdAndCompanyName updateProduct(Long id, CompanyAndIdAndCompanyName product) {
        if (!companyAndIdAndCompanyNameRepository.existsById(id)) {
            return null; // Product with given id doesn't exist
        }
        product.setId(id);
        return companyAndIdAndCompanyNameRepository.save(product);
    }

    public void deleteProduct(Long id) {
        companyAndIdAndCompanyNameRepository.deleteById(id);
    }

    

    

}
