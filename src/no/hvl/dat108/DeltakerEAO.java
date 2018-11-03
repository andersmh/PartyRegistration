package no.hvl.dat108;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DeltakerEAO {
	
	@PersistenceContext(name = "deltakerePU")
    private EntityManager em;
	
	public Deltakerliste getDeltakere() {
		return em.find(Deltakerliste.class, 1);
	}
	public void oppdaterDeltakere(Deltakerliste deltakerliste) {
		em.merge(deltakerliste);
	}

}
