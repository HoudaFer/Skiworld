package managedBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import skiworld.persistence.Parking;
import skiworld.services.IParkingManagerLocal;


@ManagedBean
@RequestScoped
public class AddParkingBean {
	@EJB
	private IParkingManagerLocal parkingManagerLocal;
	
	private int placeNumber;
	public String addParking(){
		Parking parking = new Parking();
		parking.setPlaceNumber(placeNumber);
		parkingManagerLocal.AddParking(parking);
		return "ListParking";
		
	}
	public int getPlaceNumber() {
		return placeNumber;
	}
	public void setPlaceNumber(int placeNumber) {
		this.placeNumber = placeNumber;
	}

	

}
