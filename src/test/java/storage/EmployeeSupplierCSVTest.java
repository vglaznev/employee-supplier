package storage;

import entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmployeeSupplierCSVTest {
    private final String pathToSCV = "foreign_names.csv";
    private final long numberOfEntities = 25898;

    EmployeeSupplier supplier;

    @BeforeEach
    void setUp() {
        supplier = new EmployeeSupplierCSV(pathToSCV);
    }

    @Test
    void checkIfAllEntitiesWasRead() {
        assertEquals(numberOfEntities, supplier.getListOfEmployees().size());
    }

    @Test
    void checkIfAllEntitiesWasReadCorrectly() {
        assertTrue(supplier.getListOfEmployees().stream().noneMatch(this::isEntityHasMissingFields));
    }

    boolean isEntityHasMissingFields(Employee employee) {
        return employee.getId() == null || employee.getName() == null || employee.getGender() == null || employee.getDepartment() == null || employee.getSalary() == null || employee.getBirthday() == null;
    }
}