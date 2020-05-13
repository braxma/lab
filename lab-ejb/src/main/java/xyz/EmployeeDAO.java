package xyz;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class EmployeeDAO {

    @PersistenceUnit(unitName = "mysql-unit")
    protected EntityManagerFactory emf;

    public void save(Employee employee) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(employee);
            transaction.commit();

        } catch (Exception e) {
            if(transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            entityManager.close();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Employee> fetchAll() {
        EntityManager entityManager = emf.createEntityManager();
        List<Employee> employees = new ArrayList<>();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            employees = entityManager.createQuery("select e from Employee e", Employee.class)
                    .getResultList();
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return employees;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
}
