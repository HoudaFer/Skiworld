package skiworld.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Room implements Serializable{
	private int idRoom;
	private int numberRoom;
	private RoomType roomType;
	private Hotel hotel;
	private List<RoomReservation> roomReservation;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIdRoom() {
		return idRoom;
	}
	public void setIdRoom(int idRoom) {
		this.idRoom = idRoom;
	}
	public int getNumberRoom() {
		return numberRoom;
	}
	public void setNumberRoom(int numberRoom) {
		this.numberRoom = numberRoom;
	}
	public RoomType getRoomType() {
		return roomType;
	}
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	@ManyToOne
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	@OneToMany(mappedBy="room")
	public List<RoomReservation> getRoomReservation() {
		return roomReservation;
	}
	public void setRoomReservation(List<RoomReservation> roomReservation) {
		this.roomReservation = roomReservation;
	}

	
}
