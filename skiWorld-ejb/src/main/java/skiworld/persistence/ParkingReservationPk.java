package skiworld.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
@Embeddable
public class ParkingReservationPk implements Serializable{

	private int id_parking;
	private int id_user;
	private Date dateArrival;
	private Date dateDeparture;
	private float price;
	public int getId_parking() {
		return id_parking;
	}
	public void setId_parking(int id_parking) {
		this.id_parking = id_parking;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateArrival == null) ? 0 : dateArrival.hashCode());
		result = prime * result + ((dateDeparture == null) ? 0 : dateDeparture.hashCode());
		result = prime * result + id_parking;
		result = prime * result + id_user;
		result = prime * result + Float.floatToIntBits(price);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParkingReservationPk other = (ParkingReservationPk) obj;
		if (dateArrival == null) {
			if (other.dateArrival != null)
				return false;
		} else if (!dateArrival.equals(other.dateArrival))
			return false;
		if (dateDeparture == null) {
			if (other.dateDeparture != null)
				return false;
		} else if (!dateDeparture.equals(other.dateDeparture))
			return false;
		if (id_parking != other.id_parking)
			return false;
		if (id_user != other.id_user)
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		return true;
	}
	
}
