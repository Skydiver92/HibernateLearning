package com.kuzmenko.hibernatelearning.dao;

import com.kuzmenko.hibernatelearning.model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl extends HibernateUtil implements EmployeeDAO {

    private Session session = getSession();

    @Override
    public void add(Employee employee) {
        Transaction tr = session.beginTransaction();
        session.save(employee);
        tr.commit();
        System.out.println("successfully saved");

    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees;
        Query query = session.createQuery("from Employee");
        employees = (List<Employee>) query.list();
        System.out.println("successfully got");

        return employees;
    }

    @Override
    public Employee getByID(int id) {
        Employee emp = session.get(Employee.class, id);
        System.out.println("successfully got");
        return emp;

    }

    @Override
    public void update(Employee employee) {
        Transaction tr = session.beginTransaction();
        session.flush();
        session.clear();
        session.update(employee);
        tr.commit();
        System.out.println("successfully updated");
    }

    @Override
    public void remove(Employee employee) {
        Transaction tr = session.beginTransaction();
        session.remove(employee);
        tr.commit();
        System.out.println("successfully removed");

    }
}
