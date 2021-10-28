package com.middleware.nuvelink.jasperreports.repo;

import com.middleware.nuvelink.jasperreports.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
