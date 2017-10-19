package managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.PieChartModel;

import skiworld.persistence.Hotel;
import skiworld.services.IHotelManagerLocal;

@ManagedBean
@ViewScoped
public class statHotel {
	
	private PieChartModel pieModel1;
	private List<Hotel> hotels;
	
	@EJB
	IHotelManagerLocal hotelManagerLocal;
	
	
	@PostConstruct
	public void init(){
		hotels = new ArrayList<Hotel>();
		hotels = hotelManagerLocal.getHotels();
		graph(hotels);
		
	}
	
	private void graph(List<Hotel> hotels){
		pieModel1 = new PieChartModel();
		
		for (Hotel hotel : hotels)
		{
			float n = hotel.getRating();
			pieModel1.set(hotel.getName(), n);
			
		}
		pieModel1.setTitle("Rating of hotels");
		pieModel1.setLegendPosition("w");
		
		
	}

	public PieChartModel getPieModel1() {
		return pieModel1;
	}

	public void setPieModel1(PieChartModel pieModel1) {
		this.pieModel1 = pieModel1;
	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}
	
	

}
