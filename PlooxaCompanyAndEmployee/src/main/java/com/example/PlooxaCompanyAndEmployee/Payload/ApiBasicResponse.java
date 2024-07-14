package com.example.PlooxaCompanyAndEmployee.Payload;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiBasicResponse<T> {

    private Boolean success;
    private String message;
    private T data;

    public ApiBasicResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

}
