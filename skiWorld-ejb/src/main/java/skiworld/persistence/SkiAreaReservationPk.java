package skiworld.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Embeddable
public class SkiAreaReservationPk implements Serializable {
	private int id_user;
	private int id_skiArea;
	private Date reservationDate;

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public int getId_skiArea() {
		return id_skiArea;
	}

	public void setId_skiArea(int id_skiArea) {
		this.id_skiArea = id_skiArea;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public SkiAreaReservationPk(int id_user, int id_skiArea, Date reservationDate) {
		super();
		this.id_user = id_user;
		this.id_skiArea = id_skiArea;
		this.reservationDate = reservationDate;
	}

	
	public SkiAreaReservationPk() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_skiArea;
		result = prime * result + id_user;
		result = prime * result + ((reservationDate == null) ? 0 : reservationDate.hashCode());
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
		SkiAreaReservationPk other = (SkiAreaReservationPk) obj;
		if (id_skiArea != other.id_skiArea)
			return false;
		if (id_user != other.id_user)
			return false;
		if (reservationDate == null) {
			if (other.reservationDate != null)
				return false;
		} else if (!reservationDate.equals(other.reservationDate))
			return false;
		return true;
	}

}
