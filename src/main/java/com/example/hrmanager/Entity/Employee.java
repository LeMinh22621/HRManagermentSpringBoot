package com.example.hrmanager.Entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name="employee")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    protected Integer id;

    @Column(name="employee_first_name")
    private String firstName;

    @Column(name="employee_last_name")
    private String lastName;

    @Column(name="employee_salary")
    private Double salary;
}
