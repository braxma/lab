package xyz.employee;

import java.util.List;

public interface EmployeeDAO {

    void save(Employee employee);
    List<Employee> fetchAll();

}
