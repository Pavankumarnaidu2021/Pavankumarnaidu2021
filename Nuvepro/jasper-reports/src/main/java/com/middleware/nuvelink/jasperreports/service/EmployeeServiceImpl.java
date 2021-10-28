package com.middleware.nuvelink.jasperreports.service;

import com.middleware.nuvelink.jasperreports.repo.EmployeeRepository;
import com.middleware.nuvelink.jasperreports.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public Integer createEmployee(Employee employee) {
        return repository.save(employee).getId();
    }

    @Override
    public List<Employee> listEmployees() {
        return repository.findAll();
    }
}
