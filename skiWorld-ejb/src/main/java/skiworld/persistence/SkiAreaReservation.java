package skiworld.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SkiAreaReservation implements Serializable {
	private SkiAreaReservationPk skiAreaReservationPk;
	private User user;
	private SkiArea skiArea;

	@EmbeddedId
	public SkiAreaReservationPk getSkiAreaReservationPk() {
		return skiAreaReservationPk;
	}

	public void setSkiAreaReservationPk(SkiAreaReservationPk skiAreaReservationPk) {
		this.skiAreaReservationPk = skiAreaReservationPk;
	}

	@ManyToOne
	@JoinColumn(name = "id_user", insertable = false, updatable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	@JoinColumn(name = "id_skiArea", insertable = false, updatable = false)
	public SkiArea getSkiArea() {
		return skiArea;
	}

	public void setSkiArea(SkiArea skiArea) {
		this.skiArea = skiArea;
	}

	public SkiAreaReservation(SkiAreaReservationPk skiAreaReservationPk, User user, SkiArea skiArea, Date date) {
		super();
		this.skiAreaReservationPk = new SkiAreaReservationPk(user.getIdUser(), skiArea.getIdArea(), date);
		this.user = user;
		this.skiArea = skiArea;
	}

	public SkiAreaReservation() {
		super();
	}
}
