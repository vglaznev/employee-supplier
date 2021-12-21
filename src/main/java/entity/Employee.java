package entity;

import java.util.Objects;

/**
 * Entity Employee class for work with data layer
 */
public class Employee {
    /**
     * Id of employee in csv table
     */
    private Long id;
    private String name;
    private String gender;
    private Integer salary;
    private Department department;
    private String birthday;

    public Employee() {
    }

    public Employee(long id, String name, String gender, String birthday, Department department, int salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Department getDepartment() {
        return department;
    }

    public Integer getSalary() {
        return salary;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * Overrides standard java-object equals method for employee entity
     *
     * @param o the object to compare
     * @return true if they are the same person, false - otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(gender, employee.gender) && Objects.equals(department, employee.department) && Objects.equals(salary, employee.salary) && Objects.equals(birthday, employee.birthday);
    }

    /**
     * Overrides standard java-object hashCode method for employee entity
     *
     * @return hash code of employee
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, gender, department, salary, birthday);
    }

    /**
     * Overrides standard java-object toString method for employee entity
     *
     * @return string representation of employee
     */
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
