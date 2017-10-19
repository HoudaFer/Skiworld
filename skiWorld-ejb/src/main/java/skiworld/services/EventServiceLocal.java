package skiworld.services;

import java.util.List;

import javax.ejb.Local;

import skiworld.persistence.Event;



@Local
public interface EventServiceLocal {
	
	void ajouterEvent(Event event);
	void supprimerEvent(Event event);
	void modifierEvent (Event event);
	List<Event> findAll();
	Event findById(int id);
	List<Event> ListEvents();
}
