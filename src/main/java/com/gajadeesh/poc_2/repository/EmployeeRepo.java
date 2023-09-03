package com.gajadeesh.poc_2.repository;

import com.gajadeesh.poc_2.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Integer> {

}
