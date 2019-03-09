package com.amex.hr.api.model;

import lombok.Data;

import java.util.List;

@Data
public class Employee {

    private Long id;
    private String name;
    private String title;
    private List<Long> reports;

}
