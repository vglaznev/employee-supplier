package entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Entity department class for work with data layer
 */
public class Department {
    private static AtomicLong idCounter = new AtomicLong();
    private static Map<String, Department> departments = new HashMap<>();

    private long id;
    private String name;

    private Department(String name) {
        this.id = createId();
        this.name = name;
    }

    /**
     * Create id for new department
     *
     * @return created id
     */
    private static long createId() {
        return idCounter.getAndIncrement();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Static factory method for creating department. Only way to create instance of the class.
     * It's need to avoid creation of different entities for one department
     *
     * @param name name of department
     * @return department entity
     */
    public static Department of(String name) {
        if (!departments.containsKey(name)) {
            departments.put(name, new Department(name));
        }
        return departments.get(name);
    }

    /**
     * Overrides standard java-object equals method for department entity
     *
     * @param o the object to compare
     * @return true if they are the same departments, false - otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name);
    }

    /**
     * Overrides standard java-object hashCode method for department entity
     *
     * @return hash code of department object
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /**
     * Overrides standard java-object toString method for department entity
     *
     * @return string representation of department entity
     */
    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
