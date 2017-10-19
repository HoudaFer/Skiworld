package skiworld.persistence;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class RestoTableReservation implements Serializable{
	
	private RestoTableReservationPk restoTableReservationPk;
	private User user;
	private RestoTable restotable;
	@EmbeddedId
	public RestoTableReservationPk getRestoTableReservationPk() {
		return restoTableReservationPk;
	}
	public void setRestoTableReservationPk(RestoTableReservationPk restoTableReservationPk) {
		this.restoTableReservationPk = restoTableReservationPk;
	}
	@OneToOne
	@JoinColumn(name="id_user", insertable = false, updatable = false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@ManyToOne
	@JoinColumn(name="id_table", insertable = false, updatable = false)
	public RestoTable getRestotable() {
		return restotable;
	}
	public void setRestotable(RestoTable restotable) {
		this.restotable = restotable;
	}
	

}
