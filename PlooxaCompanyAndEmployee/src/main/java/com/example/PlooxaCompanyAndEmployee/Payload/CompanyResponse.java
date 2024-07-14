package com.example.PlooxaCompanyAndEmployee.Payload;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyResponse {


    private UUID id;

    private String companyName;

    private double MobileNumber;

    private String  address;
    
    private String unickCode;
}
