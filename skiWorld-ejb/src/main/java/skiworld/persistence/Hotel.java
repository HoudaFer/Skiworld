package skiworld.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Table (name="hotels")
@Entity
public class Hotel implements Serializable{

	private int idHotel;
	private String name;
	private int phone;
	private String address;
	private float rating;
	private String email;
	private int stars;
	private List<Room> room;
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue
	public int getIdHotel() {
		return idHotel;
	}
	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}

	@OneToMany(mappedBy="hotel",cascade=CascadeType.REMOVE)
	
	public List<Room> getRoom() {
		return room;
	}
	public void setRoom(List<Room> room) {
		this.room = room;
	}
	
	@Override
	public String toString() {
		return name;
	}
	public Hotel(int idHotel, String name, int phone, String address, float rating, String email, int stars,
			List<Room> room) {
		super();
		this.idHotel = idHotel;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.rating = rating;
		this.email = email;
		this.stars = stars;
		this.room = room;
	}
	public Hotel() {
	
	}
	
	
	
}
