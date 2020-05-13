package xyz;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class WebApi extends HttpServlet {

    @Inject
    private Counter counter;
    @Inject
    private UserData userData;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);

        req.getSession().setAttribute("counter", counter.inc());
        req.getSession().setAttribute("session", session.getId());
        req.getSession().setAttribute("toDo", userData.read(session.getId()));
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);

        String text = req.getParameter("text");
        if(text != null && !text.isEmpty()) {
            userData.append(session.getId(), text);
        }

        req.getSession().setAttribute("counter", counter.inc());
        req.getSession().setAttribute("session", session.getId());
        req.getSession().setAttribute("toDo", userData.read(session.getId()));
        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }


}
