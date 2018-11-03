package no.hvl.dat108;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoggInnServlet
 */
@WebServlet("/LoggInnServlet")
public class LoggInnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/logginn.jsp").forward(request, response);

		
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		@SuppressWarnings("unchecked")
		List<Deltaker> deltakerliste = (List<Deltaker>) request.getSession().getAttribute("deltakerliste");
		
		String mobil = request.getParameter("mobil");
		String passord = request.getParameter("passord");
		 
		Deltaker d = deltakerliste.stream().filter(x -> x.getMobil().equals(mobil)).findAny().orElse(null);
		
		request.getSession().setAttribute("innlogger", d);
		
		if(d != null && PassordUtil.sjekkPassord(passord, d.getHashpassord())) {
			request.getRequestDispatcher("WEB-INF/deltagerliste.jsp").forward(request, response);
		} 
		else {
			request.getSession().setAttribute("feilmelding", "Feil brukernavn og/eller passord");
			response.sendRedirect("LoggInnServlet");
		}
	}

}
