package com.example.hrmanager.Controller;

import com.example.hrmanager.Entity.Developer;
import com.example.hrmanager.Entity.Employee;
import com.example.hrmanager.Entity.Tester;
import com.example.hrmanager.Repository.DeveloperRepository;
import com.example.hrmanager.Repository.EmployeeBaseRepository;
import com.example.hrmanager.Repository.TesterRepository;
import com.example.hrmanager.Service.DeveloperService;
import com.example.hrmanager.Service.EmployeeService;
import com.example.hrmanager.Service.TesterService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class DemoController {
    @Autowired
    private DeveloperService developerService;
    @Autowired
    private TesterService testerService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping({"/list", "/"})
    public ModelAndView defaultScreen() {
        if(getAllEmployees().size() == 0)
            addData();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("employees", getAllEmployees());
        mav.addObject("developers", getAllDevelopers());
        mav.addObject("testers", getAllTesters());
        return mav;
    }

    @PostMapping("/addDatas")
    public void addData()
    {
        List<Employee> developers = new ArrayList<>();
        Developer dev1 = new Developer();
        dev1.setFirstName("Minh");
        dev1.setLastName("Le");
        dev1.setSalary(1000000d);
        dev1.setDeveloperLanguage("Java");

        Developer dev2 = new Developer();
        dev2.setFirstName("Tuan");
        dev2.setLastName("Le");
        dev2.setSalary(2000000d);
        dev2.setDeveloperLanguage("Kotlin");

        Developer dev3 = new Developer();
        dev3.setFirstName("Binh");
        dev3.setLastName("Le");
        dev3.setSalary(3000000d);
        dev3.setDeveloperLanguage("Kotlin");

        Developer dev4 = new Developer();
        dev4.setFirstName("Vy");
        dev4.setLastName("Le");
        dev4.setSalary(4000000d);
        dev4.setDeveloperLanguage("PHP");

        Developer dev5 = new Developer();
        dev5.setFirstName("Nam");
        dev5.setLastName("Le");
        dev5.setSalary(5000000d);
        dev5.setDeveloperLanguage("JavaScript");

        developers.add(dev1);
        developers.add(dev2);
        developers.add(dev3);
        developers.add(dev4);
        developers.add(dev5);

        List<Employee> testers = new ArrayList<>();

        Tester test1 = new Tester();
        test1.setFirstName("Ngoc");
        test1.setLastName("Tran");
        test1.setSalary(1000000d);
        test1.setIsAutomated(false);

        Tester test2 = new Tester();
        test2.setFirstName("Dung");
        test2.setLastName("Thong");
        test2.setSalary(2000000d);
        test2.setIsAutomated(true);

        Tester test3 = new Tester();
        test3.setFirstName("Nhu");
        test3.setLastName("Hoang");
        test3.setSalary(3000000d);
        test3.setIsAutomated(true);

        Tester test4 = new Tester();
        test4.setFirstName("Lien");
        test4.setLastName("Trinh");
        test4.setSalary(4000000d);
        test4.setIsAutomated(false);

        Tester test5 = new Tester();
        test5.setFirstName("Thuy");
        test5.setLastName("Vo");
        test5.setSalary(5000000d);
        test5.setIsAutomated(true);

        testers.add(test1);
        testers.add(test2);
        testers.add(test3);
        testers.add(test4);
        testers.add(test5);

        employeeService.saveAll(developers);
        employeeService.saveAll(testers);
    }

    @GetMapping("/developers")
    public Iterable<Developer> getAllDevelopers()
    {
        try
        {
            return developerService.getAllDevelopers();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/testers")
    public Iterable<Tester> getAllTesters()
    {
        try
        {
            return testerService.getAllTester();
        }
            catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/employees")
    public Hashtable<Employee, Double> getAllEmployees()
    {
        try
        {
            Hashtable<Employee, Double> yearlySalary = new Hashtable<>();
            employeeService.getAllEmployees().forEach(employee -> {
                yearlySalary.put(employee, employee.getSalary()*12);
            });
            return yearlySalary;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @PatchMapping("/increaseSalary")
    public boolean increaseSalary(HttpServletResponse httpResponse)
    {
        try {
            double rate = 0.1;

            List<Integer> ids = employeeService.getAllEmployeeId();

            ids.forEach(new Consumer<Integer>() {
                @Override
                public void accept(Integer id) {
                    Employee e = employeeService.getEmployeeById(id);
                    e.setSalary(rate * e.getSalary() + e.getSalary());
                    employeeService.updateSalary(e);
                }
            });
            httpResponse.sendRedirect("/");
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @DeleteMapping("/deleteTwoLowestSalaryEmployees")
    public boolean deleteTwoLowestSalaryEmployees(HttpServletResponse httpResponse)
    {
        try
        {
            ArrayList<Employee> employeesLowest = (ArrayList<Employee>) employeeService.getTwoLowestSalaryEmployees();
            employeeService.deleteAll(employeesLowest);
            httpResponse.sendRedirect("/");
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
