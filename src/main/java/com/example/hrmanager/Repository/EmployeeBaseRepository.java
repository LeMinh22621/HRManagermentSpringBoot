package com.example.hrmanager.Repository;

import com.example.hrmanager.Entity.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface EmployeeBaseRepository<T extends Employee> extends CrudRepository<T, Integer> {

    @Modifying
    @Query("SELECT id from Employee")
    List<Integer> findAllId();

    List<Employee> findTop2ByOrderBySalaryAsc();
    @Override
    Optional<T> findById(Integer id);
}
