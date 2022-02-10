package com.example.employeecrudtestexercise.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee get(long id) {
        return employeeRepository.findById(id).orElseGet(() -> null);
    }

    public void create(Employee employee) {
        employeeRepository.save(employee);
    }

    public void update(Employee employee, long id) {
        Employee e = employeeRepository.findById(id).orElseGet(() -> null);
        if(e == null) {
            return;
        }
        e.setName(employee.getName());
        e.setPosition(employee.getPosition());
        e.setSalary(employee.getSalary());
        e.setStartDate(employee.getStartDate());
        employeeRepository.save(e);
    }

    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }
}
