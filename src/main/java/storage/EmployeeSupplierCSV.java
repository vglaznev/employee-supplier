package storage;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import entity.Department;
import entity.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.*;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Class that implements employee storage interface to work with csv files by opencsv
 */
public class EmployeeSupplierCSV implements EmployeeSupplier {

    /**
     * Symbol which separates entries in table
     */
    private static final char SEPARATOR = ';';

    /**
     * Logger to handle exception, which may occur during work with file and data
     */
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Path to csv file
     */
    private String csvFilePath;

    /**
     * Constructor with path to csv file
     *
     * @param csvFilePath - path to csv file
     */
    public EmployeeSupplierCSV(String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }


    /**
     * Maps table's entry to an employee entity
     *
     * @param entry - a line in a csv file
     * @return build Employee entity
     */
    private Employee mapEntryToEmployee(String[] entry) {
        Employee employee = null;
        try {
            employee = new Employee();
            employee.setId(Long.valueOf(entry[0]));
            employee.setName(entry[1]);
            employee.setGender(entry[2]);
            employee.setBirthday(entry[3]);
            employee.setDepartment(Department.of(entry[4]));
            employee.setSalary(Integer.valueOf(entry[5]));
        } catch (NumberFormatException exception) {
            logger.error(exception.getMessage(), exception);
        }
        return employee;
    }

    /**
     * Read data from csv table, and create list of employees entities
     *
     * @return list of employees from csv file
     */
    public List<Employee> getListOfEmployees() {
        List<Employee> employeesList = null;
        ClassLoader classLoader = getClass().getClassLoader();
        try (InputStreamReader in = new InputStreamReader(classLoader.getResourceAsStream(csvFilePath))) {

            CSVParser parser = new CSVParserBuilder()
                    .withSeparator(SEPARATOR)
                    .build();

            CSVReader reader = new CSVReaderBuilder(in)
                    .withSkipLines(1)
                    .withCSVParser(parser)
                    .build();

            employeesList = reader.readAll()
                    .stream()
                    .map(this::mapEntryToEmployee)
                    .collect(Collectors.toList());

            in.close();
            reader.close();
        } catch (IOException | CsvException | NullPointerException exception) {
            logger.error(exception.getMessage(), exception);
        }
        return employeesList;
    }
}