package managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import skiworld.persistence.Parking;

import skiworld.services.IParkingManagerLocal;
import skiworld.services.ParkingManager;

@ManagedBean
@ViewScoped
public class ListParkingBean {
	private Parking parking;
	private int placeNumber ;
	private List<Parking> parkings;
	private Boolean test=false;
	@EJB
	IParkingManagerLocal parkingManagerLocal;
	@PostConstruct
	public void init(){
		parking=new Parking();
		parkings=new ArrayList<Parking>();
		parkings=parkingManagerLocal.getParkings();
		
	}
	public String delete(Parking parking){
		parkingManagerLocal.DeleteParking(parking);
		init();
		return null;
	}
	public String update(){
		System.out.println(parking.getIdParking());
		parkingManagerLocal.UpdateParking(parking);
		init();
		return null;
	}
	public String inisialiser(){
		test=true;
		return null;
		
	}
	public Parking getParking() {
		return parking;
	}
	public void setParking(Parking parking) {
		this.parking = parking;
	}
	public int getPlaceNumber() {
		return placeNumber;
	}
	public void setPlaceNumber(int placeNumber) {
		this.placeNumber = placeNumber;
	}
	public List<Parking> getParkings() {
		return parkings;
	}
	public void setParkings(List<Parking> parkings) {
		this.parkings = parkings;
	}
	public Boolean getTest() {
		return test;
	}
	public void setTest(Boolean test) {
		this.test = test;
	}

}
