package skiworld.persistence;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ParkingReservation implements Serializable {

	private ParkingReservationPk parkingReservationPk;
	private Parking parking;
	private User user;
	@EmbeddedId
	public ParkingReservationPk getParkingReservationPk() {
		return parkingReservationPk;
	}
	public void setParkingReservationPk(ParkingReservationPk parkingReservationPk) {
		this.parkingReservationPk = parkingReservationPk;
	}
	@ManyToOne
	@JoinColumn(name = "id_parking", insertable = false, updatable = false)
	public Parking getParking() {
		return parking;
	}
	public void setParking(Parking parking) {
		this.parking = parking;
	}
	@ManyToOne
	@JoinColumn(name = "id_user", insertable = false, updatable = false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
