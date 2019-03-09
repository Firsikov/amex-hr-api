package com.amex.hr.api.endpoint;

import com.amex.hr.api.model.Employee;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
@RequestMapping("/employee")
@Api(value="Employee service", description="Operations on employees in HR system")
public class EmployeeEndpoint {

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Employee getById(@PathVariable("id") String id) {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("hskdjfks");
        employee.setTitle("dfedfs");
        return employee;
    }

}
