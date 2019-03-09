package com.amex.hr.api.endpoint;

import com.amex.hr.api.model.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeEndpoint {

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public Employee getById(@PathVariable("id") String id) {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("hskdjfks");
        employee.setTitle("dfedfs");
        return employee;
    }

}
