package com.gajadeesh.poc_2.controller;

import com.gajadeesh.poc_2.model.Employee;
import com.gajadeesh.poc_2.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;


    @GetMapping("/employees")
    @ResponseBody
    public ResponseEntity<List<Employee>> getAllEmployee(@RequestParam(required = false) String title){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/employees/{id}")
    @ResponseBody
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id){
        return employeeService.getEmployee(id);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
       return employeeService.CreateEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateCustomer(@PathVariable("id") int id, @RequestBody Employee employee){
        return employeeService.updateEmployee(employee, id);

    }

    @DeleteMapping("/employees/{id}")
    @Transactional
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") int id){
        return employeeService.deleteEmployee(id);
    }

}
