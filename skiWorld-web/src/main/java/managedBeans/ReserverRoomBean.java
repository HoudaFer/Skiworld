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

import skiworld.persistence.Admin;
import skiworld.persistence.Client;
import skiworld.persistence.Room;
import skiworld.persistence.RoomReservation;
import skiworld.persistence.RoomReservationType;
import skiworld.persistence.User;
import skiworld.services.IGestionReservationLocal;
import skiworld.services.IHotelManagerLocal;

@ManagedBean
@ViewScoped
public class ReserverRoomBean {
	private List<Room> rooms;
	private Room selectedRoom;
	private Boolean renderReserver=false;
	private Date arrivalDate;
	private Date departureDate;
	private Client client;
	private User user;
	private RoomReservation roomReservation;
	private Admin admin;
	private Float price;
	private RoomReservationType roomReservationType;
	@EJB
	IHotelManagerLocal hotelManagerLocal;
	@EJB 
	IGestionReservationLocal gestionReservationLocal;
	@ManagedProperty(value="#{authenticationBean}")
	private AuthenticationBean authenticationBean;
	
	public String reserver(){
		gestionReservationLocal.reserverRoom((Client) authenticationBean.getUser(),selectedRoom,arrivalDate,departureDate);
		
		
		System.out.println(arrivalDate.toInstant());
				return null;
			}
	@PostConstruct
	public void init(){
		rooms=hotelManagerLocal.getRooms();
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
	     
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public Room getSelectedRoom() {
		return selectedRoom;
	}

	public void setSelectedRoom(Room selectedRoom) {
		this.selectedRoom = selectedRoom;
	}

	public Boolean getRenderReserver() {
		return renderReserver;
	}

	public void setRenderReserver(Boolean renderReserver) {
		this.renderReserver = renderReserver;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public AuthenticationBean getAuthenticationBean() {
		return authenticationBean;
	}
	public void setAuthenticationBean(AuthenticationBean authenticationBean) {
		this.authenticationBean = authenticationBean;
	}
	public RoomReservation getRoomReservation() {
		return roomReservation;
	}
	public void setRoomReservation(RoomReservation roomReservation) {
		this.roomReservation = roomReservation;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public RoomReservationType getRoomReservationType() {
		return roomReservationType;
	}
	public void setRoomReservationType(RoomReservationType roomReservationType) {
		this.roomReservationType = roomReservationType;
	}

}
