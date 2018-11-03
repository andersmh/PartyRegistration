package Code.Database;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class PersonEAO {

	@PersistenceContext(name = "personPU")
	private EntityManager em;

	public Person findPerson(String phonenumber) {
		return em.find(Person.class, phonenumber);
	}

	public void addPersonToDatabase(Person person) {
		em.persist(person);
	}

	public boolean exists(String phonenumber) {
		return em.find(Person.class, phonenumber) != null;
	}

	public List<Person> getAllAttendees() {
		TypedQuery<Person> query = em.createQuery("SELECT k FROM Person k", Person.class);
		return query.getResultList();
	}
}
