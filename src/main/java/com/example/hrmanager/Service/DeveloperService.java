package com.example.hrmanager.Service;

import com.example.hrmanager.Entity.Developer;
import com.example.hrmanager.Repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeveloperService {
    @Autowired
    private DeveloperRepository developerRepository;

    public Iterable<Developer> getAllDevelopers()
    {
        return developerRepository.findAll();
    }

    public void saveAll(List<Developer> developers) {
        developers.forEach(developer -> developerRepository.save(developer));
    }
}
