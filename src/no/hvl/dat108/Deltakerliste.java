package no.hvl.dat108;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "deltakerliste")
public class Deltakerliste {

	@Id
	private int id;
	
	@OneToMany(
		        cascade = CascadeType.ALL, 
		        orphanRemoval = true,
		        fetch = FetchType.EAGER,
		        mappedBy = "deltakerliste"
		    )
	private List<Deltaker> liste = new ArrayList<>();
	
	public List<Deltaker> getDeltakerliste() {
		return liste;
	}
	
	public synchronized void leggTilDeltaker(Deltaker deltaker) {
		liste.add(deltaker);
		deltaker.setListe(this);
	}
}
