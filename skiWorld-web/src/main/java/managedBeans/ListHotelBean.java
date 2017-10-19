package managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import skiworld.persistence.Hotel;
import skiworld.services.IHotelManagerLocal;

@ManagedBean
@ViewScoped
public class ListHotelBean {
	private Hotel hotel;
	private String name;
	private int phone;
	private String address;
	private int rating;
	private String email;
	private int stars;
	private Boolean test=false;
	private List<Hotel> filtered;
	
	public List<Hotel> getFiltered() {
		return filtered;
	}
	public void setFiltered(List<Hotel> filtered) {
		this.filtered = filtered;
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
	private List<Hotel>hotels;
	@EJB
	private IHotelManagerLocal hotelManagerLocal;
	@PostConstruct
	public void init(){
		hotel=new Hotel();
		hotels=new ArrayList<Hotel>();
		hotels=hotelManagerLocal.getHotels();
		hotel.getName();
		hotel.getPhone();
		hotel.getAddress();
		hotel.getEmail();
		hotel.getRating();
		hotel.getStars();
		 
	}
	public String delete(Hotel hotel){
		hotelManagerLocal.DeleteHotel(hotel);
		init();
		return null;
	}
	public String update(){
		System.out.println (hotel.getIdHotel());
		hotelManagerLocal.UpdateHotel(hotel);
		init();
		return null;
	}
	 public String inisialiser(){
		 test=true;
		
		
		return null;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public List<Hotel> getHotels() {
		return hotels;
	}
	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}
	public IHotelManagerLocal getHotelManagerLocal() {
		return hotelManagerLocal;
	}
	public void setHotelManagerLocal(IHotelManagerLocal hotelManagerLocal) {
		this.hotelManagerLocal = hotelManagerLocal;
	}
	public Boolean getTest() {
		return test;
	}
	public void setTest(Boolean test) {
		this.test = test;
	}
	
	

}
