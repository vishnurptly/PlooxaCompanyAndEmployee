package com.example.PlooxaCompanyAndEmployee.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PlooxaCompanyAndEmployee.Model.CompanyAndIdAndCompanyName;
import com.example.PlooxaCompanyAndEmployee.Service.CompanyService;




@RestController
@RequestMapping("/VRP/company")
public class CompanyController {
    
    @Autowired
    private CompanyService  companyService;
    
    @GetMapping
    public List<CompanyAndIdAndCompanyName> getAllProducts() {
        return companyService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyAndIdAndCompanyName> getProductById(@PathVariable Long id) {
        CompanyAndIdAndCompanyName product = companyService.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/post")
    public ResponseEntity<CompanyAndIdAndCompanyName> createProduct(@RequestBody CompanyAndIdAndCompanyName companyAndIdAndCompanyName) {
        CompanyAndIdAndCompanyName createdProduct = companyService.createProduct(companyAndIdAndCompanyName);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyAndIdAndCompanyName> updateProduct(@PathVariable Long id, @RequestBody CompanyAndIdAndCompanyName product) {
        CompanyAndIdAndCompanyName updatedProduct = companyService.updateProduct(id, product);
        if (updatedProduct != null) {
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        companyService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
