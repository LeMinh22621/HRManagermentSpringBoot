package com.example.hrmanager.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name="tester")
@Getter
@Setter
public class Tester extends Employee{
    @Column(name="is_automated")
    private Boolean isAutomated;
}
