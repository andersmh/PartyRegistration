package Code.Servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Code.Database.Person;
import Code.Database.PersonEAO;
import Code.Schemas.LoginSchema;
import Code.Utilities.PasswordUtil;

@WebServlet(name = "Login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	@EJB
	private PersonEAO personEAO;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Person p = personEAO.findPerson(request.getParameter("mobil"));
		LoginSchema schema = new LoginSchema("");

		if (p != null && PasswordUtil.sjekkPassord(request.getParameter("passord"), p.getPassword())) {

			request.getSession(true).setAttribute("username", p);
			request.getSession().removeAttribute("loginmessage");
			response.sendRedirect("/deltagerliste");
		} else {

			schema.setErrortext("Ugylig brukernavn og/eller passord!");
			request.getSession().setAttribute("loginmessage", schema);
			response.sendRedirect("/login");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
	}
}
