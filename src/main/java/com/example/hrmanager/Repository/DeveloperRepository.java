package com.example.hrmanager.Repository;

import com.example.hrmanager.Entity.Developer;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DeveloperRepository extends EmployeeBaseRepository<Developer>
{

}
