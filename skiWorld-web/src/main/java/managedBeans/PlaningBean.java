package managedBeans;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import skiworld.persistence.Instructor;
import skiworld.persistence.Planing;
import skiworld.services.IHandelUser;
import skiworld.services.IHandlePlaning;

@ManagedBean
@ViewScoped
public class PlaningBean {
	@EJB
	private IHandlePlaning handlePlaning;
	@EJB
	private IHandelUser handelUser;
	private String name;
	private Date date;
	private String description;
	private Planing planing = new Planing();
	private List<Planing> planings;
	private Instructor instructor;
	private List<Instructor> instructors;

	@PostConstruct
	public void init() {
		planing = new Planing();
		planings = new ArrayList<Planing>();
		planings = handlePlaning.getPlaning();
		instructors = new ArrayList<Instructor>();
		instructors = handelUser.getInstructor();
		planing.setInstructor(new Instructor());

	}

	public String AddPlaning() {
		planing = new Planing();
		planing.setName(name);
		planing.setDate(date);
		planing.setDescription(description);
		handlePlaning.addPlaning(planing);
		planing = new Planing();
		planing.setInstructor(new Instructor());
		return "ListPlaning";
	}

	public String DeletePlaning() {
		handlePlaning.deletePlaning(planing);
		return "ListPlaning";
	}

	   public void onDateSelect(SelectEvent event) {
	        FacesContext facesContext = FacesContext.getCurrentInstance();
	        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
	    }
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Planing getPlaning() {
		return planing;
	}

	public void setPlaning(Planing planing) {
		this.planing = planing;
	}

	public IHandlePlaning getHandlePlaning() {
		return handlePlaning;
	}

	public void setHandlePlaning(IHandlePlaning handlePlaning) {
		this.handlePlaning = handlePlaning;
	}

	public List<Planing> getPlanings() {
		return planings;
	}

	public void setPlanings(List<Planing> planings) {
		this.planings = planings;
	}

	public IHandelUser getHandelUser() {
		return handelUser;
	}

	public void setHandelUser(IHandelUser handelUser) {
		this.handelUser = handelUser;
	}

	public List<Instructor> getInstructors() {
		return instructors;
	}

	public void setInstructors(List<Instructor> instructors) {
		this.instructors = instructors;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

}
