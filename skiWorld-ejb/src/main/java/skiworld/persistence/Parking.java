package skiworld.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Parking  implements Serializable{
	private int idParking;
	private int placeNumber;
	private List<ParkingReservation> parkingReservation;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIdParking() {
		return idParking;
	}
	public void setIdParking(int idParking) {
		this.idParking = idParking;
	}
	public int getPlaceNumber() {
		return placeNumber;
	}
	public void setPlaceNumber(int placeNumber) {
		this.placeNumber = placeNumber;
	}
	@OneToMany(mappedBy="parking")
	public List<ParkingReservation> getParkingReservation() {
		return parkingReservation;
	}
	public void setParkingReservation(List<ParkingReservation> parkingReservation) {
		this.parkingReservation = parkingReservation;
	}

	
	
}
