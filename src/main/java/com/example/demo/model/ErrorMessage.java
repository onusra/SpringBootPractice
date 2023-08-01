package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    HttpStatus httpStatus;
    String message;
}
