package com.amex.hr.api.service;

import com.amex.hr.api.model.Employee;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    private final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    private Map<Long, Employee> employeeMap;

    @Value("${datasource.url}")
    private String datasourceUrl;

    @PostConstruct
    private void init() {
        logger.info("Initializing EmployeeService");

        List<Employee> employees = loadEmployeeData();

        employeeMap = registerEmployeesById(employees);

        logger.info("EmployeeService initialized");
    }

    public Employee getEmployeeById(Long id) {
        return employeeMap.get(id);
    }

    private Map<Long, Employee> registerEmployeesById(List<Employee> employees) {
        Map<Long, Employee> result = new HashMap<>();
        employees.forEach(employee -> result.put(employee.getId(), employee));
        return result;
    }

    private List<Employee> loadEmployeeData() {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Employee>> typeReference = new TypeReference<List<Employee>>(){};
        logger.info("Loading employee data from {}", datasourceUrl);
        InputStream inputStream = TypeReference.class.getResourceAsStream(datasourceUrl);
        List<Employee> employees = new ArrayList<>();
        try {
            employees = mapper.readValue(inputStream, typeReference);
            logger.info("Loaded employee data successfully");
        } catch (IOException e) {
            logger.error("Failed to load employee data", e);
        }
        return employees;
    }
}
