package com.example.hrmanager.Service;

import com.example.hrmanager.Entity.Developer;
import com.example.hrmanager.Entity.Employee;
import com.example.hrmanager.Repository.EmployeeBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeBaseRepository employeeBaseRepository;

    public List<Employee> getAllEmployees()
    {
       return (List<Employee>) employeeBaseRepository.findAll();
    }

    public Employee updateSalary(Employee employee)
    {
        return (Employee) employeeBaseRepository.save(employee);
    }

    public List<Integer> getAllEmployeeId() {
        return employeeBaseRepository.findAllId();
    }

    public Employee getEmployeeById(Integer id) {
        return (Employee)employeeBaseRepository.findById(id).get();
    }

    public List<Employee> getTwoLowestSalaryEmployees() {
        return employeeBaseRepository.findTop2ByOrderBySalaryAsc();
    }

    public void deleteAll(ArrayList<Employee> employeesLowest) {
        employeeBaseRepository.deleteAll(employeesLowest);
    }

    public void saveAll(List<Employee> employees) {
        employeeBaseRepository.saveAll(employees);
    }
}
