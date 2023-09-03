package com.gajadeesh.poc_2.service;

import com.gajadeesh.poc_2.model.Employee;
import com.gajadeesh.poc_2.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    public ResponseEntity<List<Employee>> getAllEmployee(){
        try {

            List<Employee> _employee = (List<Employee>) employeeRepo.findAll();

            if (_employee.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(_employee, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public  ResponseEntity<Employee> getEmployee(int id){
        Optional<Employee> _employee = employeeRepo.findById(id);

        return _employee.map(employee -> new ResponseEntity<>(employee, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    public ResponseEntity<Employee> CreateEmployee(Employee employee){
        try {
            Employee _employee = employeeRepo.save(employee);
            return new ResponseEntity<>(_employee, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Employee> updateEmployee(Employee employee, int id){
        Optional<Employee> emp = employeeRepo.findById(id);

        if (emp.isPresent()) {
            Employee _employee = emp.get();
            _employee.setFirstname(employee.getFirstname());
            _employee.setLastname(employee.getLastname());
            _employee.setExtensionname(employee.getExtensionname());
            _employee.setBirthday(employee.getBirthday());
            employeeRepo.save(_employee);
            return new ResponseEntity<>(employeeRepo.save(_employee), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<HttpStatus> deleteEmployee(int id){
        try {
            employeeRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
