package com.middleware.nuvelink.jasperreports.service;

import com.middleware.nuvelink.jasperreports.entity.Employee;

import java.util.List;

public interface IEmployeeService {

    Integer createEmployee(Employee employee);

    List<Employee> listEmployees();
}
