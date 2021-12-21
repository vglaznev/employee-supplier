package storage;

import entity.Employee;

import java.util.List;


/**
 * Interface to work with employee storage
 */
public interface EmployeeSupplier {
    /**
     * Gets list of employees from storage
     *
     * @return List of Employees
     */
    List<Employee> getListOfEmployees();
}
