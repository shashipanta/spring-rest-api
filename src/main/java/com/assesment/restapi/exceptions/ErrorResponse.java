package com.assesment.restapi.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
public class ErrorResponse {

    private String errorCode;
    private String message;

    // getter, setter and constructor
}
