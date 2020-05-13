package xyz;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class Test {

    public static void main(String[] args) {
        try {
            EntityManagerFactory unit = Persistence.createEntityManagerFactory("mysql-unit");

            EmployeeDAO employeeDAO = new EmployeeDAO();
            employeeDAO.setEmf(unit);

            Employee employee = new Employee();
            employee.setFirsName("Leonid");
            employee.setLastName("Kuharev");
            employee.setSureName("");
            employee.setOccupation("developer");
            employee.setDepartment("feature team");
            employee.setSalary(1e5);
            employeeDAO.save(employee);

            System.out.println(employeeDAO.fetchAll());
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}
