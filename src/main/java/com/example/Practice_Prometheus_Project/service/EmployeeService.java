package com.example.Practice_Prometheus_Project.service;




import com.example.Practice_Prometheus_Project.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class EmployeeService {

    private final Map<Long, Employee> employeeMap = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public Employee create(Employee employee) {
        long id = idCounter.getAndIncrement();
        employee.setId(id);
        employeeMap.put(id, employee);
        return employee;
    }

    public List<Employee> getAll() {
        return new ArrayList<>(employeeMap.values());
    }

    public Employee getById(Long id) {
        return employeeMap.get(id);
    }

    public Employee update(Long id, Employee updated) {
        if (!employeeMap.containsKey(id)) return null;
        updated.setId(id);
        employeeMap.put(id, updated);
        return updated;
    }

    public boolean delete(Long id) {
        return employeeMap.remove(id) != null;
    }
}





