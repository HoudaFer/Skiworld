package managedBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import skiworld.persistence.Hotel;
import skiworld.services.IHotelManagerLocal;
@ManagedBean
@RequestScoped
public class AddHotelBean {
	@EJB
	private IHotelManagerLocal hotelManagerLocal;
	private String name;
	private int phone;
	private String address;
	private int rating;
	private String email;
	private int stars;
	
	public String addHotel(){
		Hotel hotel=new Hotel();
		hotel.setName(name);
		hotel.setPhone(phone);
		hotel.setAddress(address);
		hotel.setRating(rating);
		hotel.setEmail(email);
		hotel.setStars(stars);
		hotelManagerLocal.addHotel(hotel);
		return "ListHotel";
	}

	public IHotelManagerLocal getHotelManagerLocal() {
		return hotelManagerLocal;
	}

	public void setHotelManagerLocal(IHotelManagerLocal hotelManagerLocal) {
		this.hotelManagerLocal = hotelManagerLocal;
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
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
	

}
