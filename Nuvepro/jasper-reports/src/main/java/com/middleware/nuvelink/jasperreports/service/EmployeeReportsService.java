package com.middleware.nuvelink.jasperreports.service;

import com.middleware.nuvelink.jasperreports.entity.Employee;
import com.middleware.nuvelink.jasperreports.repo.EmployeeRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeReportsService {

    @Autowired
    private EmployeeRepository repository;

    public String exportEmployeesReports(String reportFormat, HttpServletResponse response) throws IOException, JRException {
        String storagePath = "D:\\jasper-reports\\jasper-reports";
        List<Employee> employeeList = repository.findAll();
        if (!CollectionUtils.isEmpty(employeeList)) {
            //Load the Jasper file for compile
            File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX+"employees.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employeeList);
            Map<String, Object> params = new HashMap<>();
            params.put("createdBy", "Nuvepro");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
            if (reportFormat.equalsIgnoreCase("html")) {
                JasperExportManager.exportReportToHtmlFile(jasperPrint, storagePath+"emplyees.html");
            }
            if (reportFormat.equalsIgnoreCase("pdf")) {
                JasperExportManager.exportReportToPdfFile(jasperPrint, storagePath+"emplyees.pdf");
            }
            if (reportFormat.equalsIgnoreCase("xml")) {
                JasperExportManager.exportReportToXmlFile(jasperPrint, storagePath+"emplyees.xml", false);
            }
            if (reportFormat.equalsIgnoreCase("excel")) {

            }
            return "Report generated and stored location: "+storagePath;
        }
        return "Report is not generated.";
    }
}
