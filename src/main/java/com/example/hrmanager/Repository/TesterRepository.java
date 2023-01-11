package com.example.hrmanager.Repository;

import com.example.hrmanager.Entity.Tester;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TesterRepository extends EmployeeBaseRepository<Tester>
{

}