package skiworld.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import skiworld.persistence.Event;
import skiworld.persistence.User;

/**
 * Session Bean implementation class EventService
 */
@Stateless
public class EventService implements  EventServiceLocal {

	@PersistenceContext
	EntityManager em;
	
    public EventService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void ajouterEvent(Event event) {
		// TODO Auto-generated method stub
		em.persist(event);
		
	}

	@Override
	public void supprimerEvent(Event event) {
		// TODO Auto-generated method stub
		//try{
			//em.remove(em.merge(event));
			//}catch(Exception e){
			//	return false;
			//}
			//return true;
		//em.remove(em.merge(event));
		
		event = em.find(Event.class, event.getIdEvent());
		// il faut supprimer le bout master d'abord
		 for (User P : event.getPlayers()) {
		   em.remove(P);
	}
		 em.remove(em.merge(event));
		
		
		
	}

	@Override
	public void modifierEvent(Event event) {
		// TODO Auto-generated method stub
		em.merge(event);
	}

	@Override
	public List<Event> findAll() {
		return em.createQuery("Select e from Event e ").getResultList();
	}

	@Override
	public Event findById(int id) {
		
		//return em.find(Event.class, id);
		return null;
	}

	@Override
	public List<Event> ListEvents() {
		
		Query q=em.createQuery("select p from Event p ");
		return q.getResultList();
	}

}
