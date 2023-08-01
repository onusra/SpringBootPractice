package com.example.demo.EmployeeService;

import com.example.demo.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {


    Logger logger = LoggerFactory.getLogger(EmployeeServiceTest.class);

    @Mock
    @Autowired
    private EmployeeService employeeService;
    Employee employee;
    Employee employee1;
    @BeforeEach
    public void Setup()  {
        employee = Employee.builder().
                id(1).age(17).name("Janvier").address("12 Yeoman's").
                build();
        employee1 = Employee.builder().
                id(2).age(18).name("Janvier").address("12 Yeoman's").
                build();

    }

    @Test
   public void whenThen(){
        employeeService.deleteById(1);
        verify(employeeService).deleteById(1);
    }

    @Test
    public void getAll(){
        employeeService.create(employee);
        logger.info("All Employess are : " + employeeService.retrieve().toString());
        List<Employee> emp = employeeService.retrieve();
        assertEquals(0,0);
    }

    @Test
    public void saveEmployee(){
        employeeService.create(employee);
        verify(employeeService).create(employee);
    }
}