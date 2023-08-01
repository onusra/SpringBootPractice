package com.example.demo.EmployeeService;

import com.example.demo.errohandling.ExceptionHandling;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    //Logging here

    Logger loggger = LoggerFactory.getLogger(EmployeeService.class);
    public void create(Employee employee) {
        loggger.info("Employee with this info was created : " + employee);

        employeeRepo.save(employee);
    }
    public List<Employee> retrieve(){
        loggger.info(employeeRepo.findAll().toString());
        return employeeRepo.findAll();
    }

    public Employee getEmployeeById(int id) throws ExceptionHandling {

        Optional<Employee>  employee = employeeRepo.findById(id);
        if(employee.isPresent()) {
            loggger.info(employee.get().toString());
            return employee.get();
        }else {
            throw new ExceptionHandling("No employee with such id");
        }

    }
    public void update(Employee employee, int id){
        employeeRepo.deleteById(id);
        employeeRepo.save(employee);
    }

    public Employee findByName(String name){
        return employeeRepo.findByName(name);
    }
    public void deleteById(int id) {
        employeeRepo.deleteById(id);
    }
}
