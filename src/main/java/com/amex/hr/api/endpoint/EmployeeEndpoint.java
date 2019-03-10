package com.amex.hr.api.endpoint;

import com.amex.hr.api.model.Employee;
import com.amex.hr.api.service.EmployeeService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
@RequestMapping("/employee")
@Api(value="Employee service", description="Operations on employees")
public class EmployeeEndpoint {

    private final Logger logger = LoggerFactory.getLogger(EmployeeEndpoint.class);

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeEndpoint(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Employee getById(@PathVariable("id") Long id) {
        logger.info("Received request for employee with id {}", id);
        Employee employee = employeeService.getEmployeeById(id);
        if(employee != null) {
            logger.info("Found employee {} with id {}", employee.getName(), id);
        } else {
            logger.info("Employee with id {} not found", id);
        }
        return employee;
    }

}
