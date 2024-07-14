package com.example.PlooxaCompanyAndEmployee.Model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
@Entity
@Table 
public class CompanyAndIdAndCompanyName {
    @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String companyName;

    private double MobileNumber;

    private String  address;
    
    private String unickCode;



    
    public CompanyAndIdAndCompanyName() {
    }
    

    public CompanyAndIdAndCompanyName(Long id, String companyName, double mobileNumber, String address,
            String unickCode) {
        this.id = id;
        this.companyName = companyName;
        MobileNumber = mobileNumber;
        this.address = address;
        this.unickCode = unickCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(double mobileNumber) {
        MobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUnickCode() {
        return unickCode;
    }

    public void setUnickCode(String unickCode) {
        this.unickCode = unickCode;
    }
    
}
