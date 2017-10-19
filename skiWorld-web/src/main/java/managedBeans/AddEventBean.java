package managedBeans;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;

import skiworld.persistence.Event;
import skiworld.services.EventServiceLocal;

@ManagedBean
@ViewScoped
public class AddEventBean {
	@EJB
	EventServiceLocal eventServiceLocal;
	
	private List<Event> events= new ArrayList<>();
	
	private List<Event> eventss;
	
	private Boolean renderUpdateForm = false;
	
	
	Event event = new Event();
	private String name;
	private int numberGuests;
	private String place;
	private Date dateEvent;
	
	
	public String AjouterEvent(){
	Event event = new Event();
	
	event.setName(name);
	event.setNumberGuests(numberGuests);
	event.setPlace(place);
	event.setDateEvent(dateEvent);
	eventServiceLocal.ajouterEvent(event);
	return "AddEvent";
	}
	
	

	public EventServiceLocal getEventServiceLocal() {
		return eventServiceLocal;
	}


	public void setEventServiceLocal(EventServiceLocal eventServiceLocal) {
		this.eventServiceLocal = eventServiceLocal;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getNumberGuests() {
		return numberGuests;
	}


	public void setNumberGuests(int numberGuests) {
		this.numberGuests = numberGuests;
	}


	public String getPlace() {
		return place;
	}


	public void setPlace(String place) {
		this.place = place;
	}


	


	public Date getDateEvent() {
		return dateEvent;
	}



	public void setDateEvent(Date dateEvent) {
		this.dateEvent = dateEvent;
	}



	public List<Event> getEvents() {
		
		return events;
	}


	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	@PostConstruct
	public void init()
	{
		event= new Event();
		events = eventServiceLocal.findAll();
		
	}
	
	public String delete(Event event) {

		eventServiceLocal.supprimerEvent(event);
		init();
		return null;
	}
	
	public String updateEvent() {
		System.out.println(event.getIdEvent());
		eventServiceLocal.modifierEvent(event);
		init();
		return null;
	}


	public Boolean getRenderUpdateForm() {
		return renderUpdateForm;
	}


	public void setRenderUpdateForm(Boolean renderUpdateForm) {
		this.renderUpdateForm = renderUpdateForm;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	
	public String inisialiser() {
		renderUpdateForm = true;

		return null;
	}



	public List<Event> getEventss() {
		return eventss;
	}



	public void setEventss(List<Event> eventss) {
		this.eventss = eventss;
	}
	
	
	
	
}
