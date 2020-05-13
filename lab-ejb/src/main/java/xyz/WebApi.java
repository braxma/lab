package xyz;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/")
public class WebApi extends HttpServlet {

    @Inject
    EmployeeDAO employeeDAO;

    ArrayList<Employee> localEmployees = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);

//        List<Employee> employees = employeeDAO.fetchAll();

        Employee employee = new Employee();
        employee.setFirsName("Leonid");
        employee.setLastName("Kuharev");
        employee.setSureName("");
        employee.setOccupation("developer");
        employee.setDepartment("feature team");
        employee.setSalary(1e5);
        if(localEmployees.size() == 0) {
            localEmployees.add(employee);
        }

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        req.setAttribute("employeeList", localEmployees);
        req.getSession().setAttribute("session", session.getId());
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String sureName = req.getParameter("sureName");
        String occupation = req.getParameter("occupation");
        String department = req.getParameter("department");
        String salary = req.getParameter("salary");

        if(firstName == null || firstName.isEmpty()) {
            req.getSession().setAttribute("session", session.getId());
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
            return;
        }

        Employee employee = new Employee();
        employee.setFirsName(firstName);
        employee.setLastName(lastName);
        employee.setSureName(sureName);
        employee.setOccupation(occupation);
        employee.setDepartment(department);
        employee.setSalary(salary != null && !salary.isEmpty() ? Double.parseDouble(salary) : 0d);

        localEmployees.add(employee);
//        employeeDAO.save(employee);

        req.setAttribute("employeeList", localEmployees);
        req.getSession().setAttribute("session", session.getId());
        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }

}
