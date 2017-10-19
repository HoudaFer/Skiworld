package skiworld.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class RoomReservation implements Serializable {
	private RoomReservationPk roomReservationPk;
	private RoomReservationType roomReservationType;
	private float price;
	private boolean isCheck;
	private User user;
	private Room room;

	@EmbeddedId
	public RoomReservationPk getRoomReservationPk() {
		return roomReservationPk;
	}

	public void setRoomReservationPk(RoomReservationPk roomReservationPk) {
		this.roomReservationPk = roomReservationPk;
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
	@JoinColumn(name = "id_room", insertable = false, updatable = false)
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public RoomReservationType getRoomReservationType() {
		return roomReservationType;
	}

	public void setRoomReservationType(RoomReservationType roomReservationType) {
		this.roomReservationType = roomReservationType;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean getIsCheck() {
		return isCheck;
	}

	public void setIsCheck(boolean isCheck) {
		this.isCheck = isCheck;
	}

}
