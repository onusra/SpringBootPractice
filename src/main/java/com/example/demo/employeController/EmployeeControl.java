package com.example.demo.employeController;


import com.example.demo.EmployeeService.EmployeeService;
import com.example.demo.errohandling.ExceptionHandling;
import com.example.demo.model.Employee;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import com.example.demo.EmployeeService.EmployeeService;

@RestController
@CrossOrigin
public class EmployeeControl {
    @Autowired
    EmployeeService employeeService;

    Logger logger = LoggerFactory.getLogger(EmployeeControl.class);

    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> getAll() {

        return ResponseEntity.ok(employeeService.retrieve());
        //return ResponseEntity.ok("");

    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Employee employee) {
        employeeService.create(employee);

        return ResponseEntity.ok("Welcome Home");
    }

    @GetMapping("/byName/{name}")
    public Employee findByName(@PathVariable("name") String name){
        return employeeService.findByName(name);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id){
        employeeService.deleteById(id);
    }
    @GetMapping("/get/{id}")
    public Employee getEmloyeeByID(@PathVariable("id") int id) throws ExceptionHandling {
        return employeeService.getEmployeeById(id);
    }
}
