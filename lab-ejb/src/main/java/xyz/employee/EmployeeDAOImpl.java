package xyz.employee;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@EmployeeMySqlImpl
public class EmployeeDAOImpl implements EmployeeDAO {

    @PersistenceContext(unitName = "MySQLUnit")
    private EntityManager entityManager;

    @Override
    public void save(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    public List<Employee> fetchAll() {
        return entityManager
                .createQuery("FROM Employee m", Employee.class)
                .getResultList();
    }

}
