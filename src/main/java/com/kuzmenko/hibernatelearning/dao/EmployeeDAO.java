package com.kuzmenko.hibernatelearning.dao;

import com.kuzmenko.hibernatelearning.model.Employee;

import java.util.List;

public interface EmployeeDAO {


    //create
    void add(Employee employee);

    //read
    List<Employee> getAll();

    Employee getByID(int id);

    //update
    void update(Employee employee);

    //delete
    void remove(Employee employee);

}
