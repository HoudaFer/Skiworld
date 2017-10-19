package managedBeans;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import skiworld.persistence.Client;
import skiworld.persistence.Parking;
import skiworld.persistence.ParkingReservation;
import skiworld.services.IGestionReservationLocal;
import skiworld.services.IParkingManagerLocal;

@ManagedBean
@ViewScoped
public class ReserverParkingBean {
	private List<Parking>parkings;
	private Parking selectedParking;
	private Boolean renderReserver=false;
	private Date dateArrival;
	private Date dateDeparture;
	private Client client;
	private ParkingReservation parkingReservation;
	
	@EJB
	IGestionReservationLocal gestionReservationLocal;
	@EJB
	IParkingManagerLocal parkingManagerLocal;
	@ManagedProperty(value="#{authenticationBean}")
	private AuthenticationBean authenticationBean;
	
	public String reserver(){
		gestionReservationLocal.reserverParking((Client)authenticationBean.getUser(), selectedParking, dateArrival, dateDeparture);
		return null;
	}
   @PostConstruct
   public void init(){
	   parkings=parkingManagerLocal.getParkings();
   }
   public void onDateSelect(SelectEvent event) {
       FacesContext facesContext = FacesContext.getCurrentInstance();
       SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
       facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
   }
 public void onDateSelect1(SelectEvent event1) {
       FacesContext facesContext = FacesContext.getCurrentInstance();
       SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
       facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event1.getObject())));
   }
public List<Parking> getParkings() {
	return parkings;
}
public void setParkings(List<Parking> parkings) {
	this.parkings = parkings;
}
public Parking getSelectedParking() {
	return selectedParking;
}
public void setSelectedParking(Parking selectedParking) {
	this.selectedParking = selectedParking;
}
public Boolean getRenderReserver() {
	return renderReserver;
}
public void setRenderReserver(Boolean renderReserver) {
	this.renderReserver = renderReserver;
}
public Date getDateArrival() {
	return dateArrival;
}
public void setDateArrival(Date dateArrival) {
	this.dateArrival = dateArrival;
}
public Date getDateDeparture() {
	return dateDeparture;
}
public void setDateDeparture(Date dateDeparture) {
	this.dateDeparture = dateDeparture;
}
public Client getClient() {
	return client;
}
public void setClient(Client client) {
	this.client = client;
}
public ParkingReservation getParkingReservation() {
	return parkingReservation;
}
public void setParkingReservation(ParkingReservation parkingReservation) {
	this.parkingReservation = parkingReservation;
}
public AuthenticationBean getAuthenticationBean() {
	return authenticationBean;
}
public void setAuthenticationBean(AuthenticationBean authenticationBean) {
	this.authenticationBean = authenticationBean;
}
   
   
}
