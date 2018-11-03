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

@WebServlet(name = "Bekreftelse", urlPatterns = "/bekreftelse")
public class BekreftelseServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/bekreftelse.jsp").forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("username") != null)
			request.getRequestDispatcher("WEB-INF/bekreftelse.jsp").forward(request, response);
		else
			response.sendRedirect("/");

	}
}
