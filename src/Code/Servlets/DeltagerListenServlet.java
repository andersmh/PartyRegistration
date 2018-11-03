package Code.Servlets;

import Code.Database.Person;
import Code.Database.PersonEAO;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "Deltagerlisten", urlPatterns = "/deltagerliste")
public class DeltagerListenServlet extends HttpServlet {

    @EJB
    private PersonEAO personEAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/deltagerliste.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("username") != null) {
            List<Person> personList = personEAO.getAllAttendees().stream().
                    sorted(Comparator.comparing(Person::getFirst_name).thenComparing(Person::getLast_name))
                    .collect(Collectors.toList());
            request.getSession().setAttribute("users", personList);
            request.getRequestDispatcher("WEB-INF/deltagerliste.jsp").forward(request, response);
        } else
            response.sendRedirect("/login");
    }


}
