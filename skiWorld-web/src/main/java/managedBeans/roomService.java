package managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import skiworld.persistence.Hotel;
import skiworld.services.IHotelManagerLocal;

@ManagedBean(name="roomService", eager = true)
@ApplicationScoped
public class roomService {
	
	@EJB
	private IHotelManagerLocal hotelManagerLocal;
	
	private List<Hotel> hotels;
	
	@PostConstruct
	public void init(){
		hotels=new ArrayList<Hotel>();
		hotels =hotelManagerLocal.getHotels();
		 
	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

}
