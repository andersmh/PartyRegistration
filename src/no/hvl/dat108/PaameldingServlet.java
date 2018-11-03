package no.hvl.dat108;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaameldingServlet
 */
@WebServlet("/PaameldingServlet")
public class PaameldingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private DeltakerEAO deltakereEAO;
	private Deltakerliste deltakerliste;
	private Validering validering;

	@Override
	public void init() throws ServletException {
		deltakerliste = deltakereEAO.getDeltakere();
	}

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
			request.getSession().setAttribute("deltakerliste", deltakerliste.getDeltakerliste());
			request.getRequestDispatcher("WEB-INF/paameldingsskjema.jsp")
			.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
			validering = new Validering(request);
			
			request.getSession().setAttribute("validering", validering);
			
			if(validering.isAllInputGyldig()) {
				String hashpassord = PassordUtil.krypterPassord(request.getParameter("passord"));
				deltakerliste.leggTilDeltaker(
						new Deltaker(validering.getKjonn(),
						validering.getFornavn() + " " + validering.getEtternavn(),
						hashpassord, 
						validering.getMobil()));
				deltakereEAO.oppdaterDeltakere(deltakerliste);
				Deltaker d = deltakerliste.getDeltakerliste().stream().filter(x -> x.getMobil().equals(validering.getMobil())).findAny().orElse(null);
				request.getSession().setAttribute("innlogger", d);
				request.getRequestDispatcher("WEB-INF/paameldingsbekreftelse.jsp").forward(request, response);
				
	
			}
			// innlogging godkjent, lag deltaker og send til bekreftelse.
			response.sendRedirect("PaameldingServlet");
	}

}
