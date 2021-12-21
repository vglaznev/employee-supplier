package repository;

import entity.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> getListOfEmployees();
}
