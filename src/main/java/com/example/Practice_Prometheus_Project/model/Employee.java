package com.example.Practice_Prometheus_Project.model;



import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Long id;
    private String name;
    private String department;
    private double salary;
}

