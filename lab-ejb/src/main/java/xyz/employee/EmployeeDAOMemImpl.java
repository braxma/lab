package xyz.employee;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@EmployeeMemImpl
public class EmployeeDAOMemImpl implements EmployeeDAO {

    private List<Employee> list = new ArrayList<>();

    @Override
    public void save(Employee employee) {
        list.add(employee);
    }

    @Override
    public List<Employee> fetchAll() {
        return new ArrayList<>(list);
    }

}
