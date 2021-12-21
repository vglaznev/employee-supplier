package entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class Department {
    private static AtomicLong idCounter = new AtomicLong();
    private static Map<String, Department> departments = new HashMap<>();

    private long id;
    private String name;

    private Department(String name) {
        this.id = createId();
        this.name = name;
    }

    private static long createId(){
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

    public static Department of(String name) {
        if (!departments.containsKey(name)) {
            departments.put(name, new Department(name));
        }
        return departments.get(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Department{" +
                ", name='" + name + '\'' +
                '}';
    }
}
