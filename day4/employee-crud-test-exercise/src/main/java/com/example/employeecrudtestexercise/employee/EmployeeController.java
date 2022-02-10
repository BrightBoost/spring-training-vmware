package com.example.employeecrudtestexercise.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAll();
    }

    @GetMapping("{id}")
    public Employee getEmployee(@PathVariable long id) {
        return employeeService.get(id);

    }

    @PostMapping
    public void createEmployee(@RequestBody Employee employee) {
        employeeService.create(employee);
    }

    @PutMapping("{id}")
    public void updateEmployee(@RequestBody Employee employee, @PathVariable long id) {
        employeeService.update(employee, id);
    }

    @DeleteMapping
    public void deleteEmployee(@RequestBody Employee employee) {
        employeeService.delete(employee);
    }
}
