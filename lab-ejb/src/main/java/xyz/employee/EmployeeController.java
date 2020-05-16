package xyz.employee;


import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named("employees")
@RequestScoped
public class EmployeeController {

    private Employee employee;
    private List<Employee> employees;

    @Inject @EmployeeMySqlImpl
    private EmployeeDAO employeeDAO;

    @PostConstruct
    public void init() {
        employees = employeeDAO.fetchAll();
        Employee init = new Employee();
        init.firsName = "First Name";
        init.lastName = "Last Name";
        init.department = "Department";
        init.occupation = "Occupation";
        init.salary = 0d;
        employee = init;
    }

    public void add() {
        employeeDAO.save(employee);
        employees.add(employee);
        employee = new Employee();
    }

    public Employee getEmployee() {
        return employee;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

}
