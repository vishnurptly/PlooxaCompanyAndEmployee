package com.example.PlooxaCompanyAndEmployee.Mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.example.PlooxaCompanyAndEmployee.Model.CompanyAndIdAndCompanyName;
import com.example.PlooxaCompanyAndEmployee.Payload.CompanyResponse;
import com.example.PlooxaCompanyAndEmployee.Payload.CompanySaveRequest;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface companyMapper {
    
    companyMapper INSTANCE = Mappers.getMapper(companyMapper.class);

    CompanyResponse map(CompanyAndIdAndCompanyName companyAndIdAndCompanyName);

    List<CompanyResponse> map(List<CompanyAndIdAndCompanyName> companyAndIdAndCompanyNames);

    CompanyAndIdAndCompanyName map(CompanySaveRequest  companySaveRequest );

    CompanyAndIdAndCompanyName update(
        @MappingTarget CompanyAndIdAndCompanyName CompanyMapper,
        CompanySaveRequest   companySaveRequest);
}
