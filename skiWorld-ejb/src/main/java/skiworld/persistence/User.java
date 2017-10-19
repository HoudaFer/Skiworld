package skiworld.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Status")
public class User implements Serializable {

	private int idUser;
	private String lastName;
	private String firstName;
	private String cin;
	private String phone;
	private String email;
	private String adress;
	private String password;
	private String login;
	private List<PurchaseDetail> purchaseDetail;
	private List<RoomReservation> roomReservation;
	private List<RestoTable> restoTable ;
	private List<Claim> claim;
	private List<Event> event;
	private Event evenement;
	private List<ParkingReservation> parkingReservation;
	private List<Picture> picture;
	private List<Video> video;
	private List<SkiAreaReservation> skiAreaReservation ;
	private String status;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
@OneToMany(mappedBy="user")
	public List<PurchaseDetail> getPurchaseDetail() {
		return purchaseDetail;
	}

	public void setPurchaseDetail(List<PurchaseDetail> purchaseDetail) {
		this.purchaseDetail = purchaseDetail;
	}
@OneToMany(mappedBy="user")
	public List<RestoTable> getTable() {
		return restoTable;
	}

	public void setTable(List<RestoTable> restoTable) {
		this.restoTable = restoTable;
	}
@OneToMany(mappedBy="user")
	public List<Claim> getClaim() {
		return claim;
	}

	public void setClaim(List<Claim> claim) {
		this.claim = claim;
	}
@ManyToMany
	public List<Event> getEvent() {
		return event;
	}

	public void setEvent(List<Event> event) {
		this.event = event;
	}
@OneToMany(mappedBy="user")
	public List<ParkingReservation> getParkingReservation() {
		return parkingReservation;
	}

	public void setParkingReservation(List<ParkingReservation> parkingReservation) {
		this.parkingReservation = parkingReservation;
	}
@OneToMany(mappedBy="user")
	public List<Picture> getPicture() {
		return picture;
	}

	public void setPicture(List<Picture> picture) {
		this.picture = picture;
	}
@OneToMany(mappedBy="user")
	public List<Video> getVideo() {
		return video;
	}

	public void setVideo(List<Video> video) {
		this.video = video;
	}
@OneToMany(mappedBy="user")
	public List<SkiAreaReservation> getSkiAreaReservation() {
		return skiAreaReservation;
	}

	public void setSkiAreaReservation(List<SkiAreaReservation> skiAreaReservation) {
		this.skiAreaReservation = skiAreaReservation;
	}
@OneToMany(mappedBy="user")
	public List<RoomReservation> getRoomReservation() {
		return roomReservation;
	}

	public void setRoomReservation(List<RoomReservation> roomReservation) {
		this.roomReservation = roomReservation;
	}
@Transient
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@ManyToOne 
	public Event getEvenement() {
		return evenement;
	}
	public void setEvenement(Event evenement) {
		this.evenement = evenement;
	}





}
