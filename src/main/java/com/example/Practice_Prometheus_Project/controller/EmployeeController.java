package com.example.Practice_Prometheus_Project.controller;



import com.example.Practice_Prometheus_Project.model.Employee;
import com.example.Practice_Prometheus_Project.service.EmployeeService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService service;

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        logger.info("Creating employee: {}", employee.getName());
        return service.create(employee);
    }

    @GetMapping
    public List<Employee> getAll() {
        logger.info("Fetching all employees");
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        logger.info("Fetching employee with ID: {}", id);
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee employee) {
        logger.info("Updating employee with ID: {}", id);
        return service.update(id, employee);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        logger.info("Deleting employee with ID: {}", id);
        return service.delete(id) ? "Deleted" : "Not Found";
    }
}








