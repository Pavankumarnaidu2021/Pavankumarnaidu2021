package com.middleware.nuvelink.jasperreports.rest;

import com.middleware.nuvelink.jasperreports.entity.Employee;
import com.middleware.nuvelink.jasperreports.service.EmployeeReportsService;
import com.middleware.nuvelink.jasperreports.service.EmployeeServiceImpl;
import com.middleware.nuvelink.jasperreports.contants.EmployeeUrlContants;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private EmployeeReportsService reportsService;

    @Autowired
    private EmployeeServiceImpl service;

    @GetMapping(EmployeeUrlContants.HOME_URL)
    public String sayHello() {
        return "Hello Welcome..!";
    }

    @PostMapping(EmployeeUrlContants.SAVE_EMPLOYEE_URL)
    public ResponseEntity createNewEmployee(@RequestBody Employee employee) {
        if (employee != null) {
            service.createEmployee(employee);
        }
        return new ResponseEntity("Employee created successfully...!", HttpStatus.OK);
    }

    @GetMapping(EmployeeUrlContants.LIST_EMPLOYEE_URL)
    public ResponseEntity listAllEmpoyees() {
        List<Employee> employeeList = service.listEmployees();
        return new ResponseEntity(employeeList, HttpStatus.OK);
    }

    @GetMapping(EmployeeUrlContants.GET_REPORT_URL+"/{format}")
    public String generateEmployeeReports(@PathVariable String format, HttpServletResponse response) throws JRException, IOException {
        return reportsService.exportEmployeesReports(format, response);
    }
}
