package Code.Servlets;

import Code.Database.Person;
import Code.Database.PersonEAO;
import Code.Schemas.RegistrerSchema;
import Code.Utilities.PasswordUtil;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Registrer", urlPatterns = "/")

public class RegistrerServlet extends HttpServlet {

    @EJB
    private PersonEAO personEAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RegistrerSchema schema = new RegistrerSchema(request);

     
        if (schema.isValid() && !personEAO.exists(schema.getMobile())) {

            
            Person p = new Person(schema);
            p.setPassword(PasswordUtil.krypterPassord(p.getPassword()));
            personEAO.addPersonToDatabase(p);

          
            request.getSession().removeAttribute("schema");

            request.getSession(true);
            request.getSession().setAttribute("username", p);
            response.sendRedirect("/bekreftelse");
        } else {
            schema.setMobile("");
            schema.setErrorMobile("Something went wrong here!");
            request.getSession().setAttribute("schema", schema);
            response.sendRedirect("/");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
    }
}
