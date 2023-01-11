package com.example.hrmanager.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "developer")
@Getter
@Setter
public class Developer extends Employee{
    @Column(name="developer_language")
    private String developerLanguage;
}
