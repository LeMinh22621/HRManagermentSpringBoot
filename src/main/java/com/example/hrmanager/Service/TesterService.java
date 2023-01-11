package com.example.hrmanager.Service;

import com.example.hrmanager.Entity.Tester;
import com.example.hrmanager.Repository.TesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TesterService {
    @Autowired
    private TesterRepository testerRepository;

    public Iterable<Tester> getAllTester()
    {
        return testerRepository.findAll();
    }

    public void saveAll(List<Tester> testers) {
        testerRepository.saveAll(testers);
    }
}
