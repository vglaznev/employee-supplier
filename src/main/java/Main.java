import entity.Employee;
import storage.EmployeeSupplier;
import storage.EmployeeSupplierCSV;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String pathToCSV = "foreign_names.csv";
        EmployeeSupplier repository= new EmployeeSupplierCSV(pathToCSV);
        List<Employee> listOfEmployees= repository.getListOfEmployees();
        listOfEmployees.stream().limit(10).forEach(System.out::println);
        System.out.println(listOfEmployees.size());
    }
}
