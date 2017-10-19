package managedBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import skiworld.persistence.Restaurant;
import skiworld.services.IManageRestaurant;

@ManagedBean
@ViewScoped
public class RestaurantBean {
	
	private int idRestaurant;
	private String name;
	private String phone;
	private int starRating;
	private Date openDate;
	private Date closeDate;
	private String location;
	private Boolean renderUpdateForm = false;
	private Restaurant restaurant;
	private List<Restaurant> restaurants;
	@EJB
	private IManageRestaurant managerestaurant;
	
	public String addingRestaurant() {
		restaurant = new Restaurant();
		restaurant.setIdRestaurant(idRestaurant);
		restaurant.setName(name);
		restaurant.setPhone(phone);
		restaurant.setStarRating(starRating);
		restaurant.setOpenDate(openDate);
		restaurant.setCloseDate(closeDate);
		restaurant.setLocation(location);
	
		managerestaurant.addRestaurant(restaurant);
		return "welcome2";
		
	}
	
	@PostConstruct
	public void init(){ 
		restaurant= new Restaurant();
		setRestaurants(new ArrayList<>());
		setRestaurants(managerestaurant.FindRestaurant());
		restaurant.getIdRestaurant();
		restaurant.getName();
		restaurant.getLocation();
		restaurant.getPhone();
		}
	
	public String delete (Restaurant restaurant) {
		managerestaurant.deleteRestaurant(restaurant);
		init();
		return null;
	}
	
	public String updateRestaurant() {
		System.out.println(restaurant.getIdRestaurant());
		managerestaurant.updateRestaurant(restaurant);
		return null;
		}
	
	public int getIdRestaurant() {
		return idRestaurant;
	}
	public void setIdRestaurant(int idRestaurant) {
		this.idRestaurant = idRestaurant;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getStarRating() {
		return starRating;
	}
	public void setStarRating(int starRating) {
		this.starRating = starRating;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	public Date getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	public Boolean getRenderUpdateForm() {
		return renderUpdateForm;
	}
	public void setRenderUpdateForm(Boolean renderUpdateForm) {
		this.renderUpdateForm = renderUpdateForm;
	}
	public IManageRestaurant getManagerestaurant() {
		return managerestaurant;
	}
	public void setManagerestaurant(IManageRestaurant managerestaurant) {
		this.managerestaurant = managerestaurant;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}
	
	

}
