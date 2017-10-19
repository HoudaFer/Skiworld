package managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.PieChartModel;

import skiworld.persistence.Hotel;
import skiworld.persistence.Room;
import skiworld.persistence.RoomReservation;
import skiworld.services.IGestionReservationLocal;
import skiworld.services.IHotelManagerLocal;

@ManagedBean
@ViewScoped
public class StatReservation {

	private PieChartModel pieModel1;
	private List<RoomReservation> rooms;
	private List<Float> lst;
	
	@EJB
	IHotelManagerLocal hotelManagerLocal;
	@EJB
	IGestionReservationLocal gestion;
	
	
	@PostConstruct
	public void init(){
		rooms = new ArrayList<RoomReservation>();
		lst = new ArrayList<>();
		lst = gestion.priceReservation();
		rooms = gestion.getDistinctRoomReservation();
		graph(rooms);
		
	}
	
	private void graph(List<RoomReservation> rooms){
		pieModel1 = new PieChartModel();
		
		for (int i=0;i<lst.size();i++)
		{
			
			pieModel1.set(rooms.get(i).getRoom().getHotel().getName(),lst.get(i));
			
		}
		pieModel1.setTitle("Statistics of rooms");
		pieModel1.setLegendPosition("w");
		
		
	}

	public PieChartModel getPieModel1() {
		return pieModel1;
	}

	public void setPieModel1(PieChartModel pieModel1) {
		this.pieModel1 = pieModel1;
	}

	public List<RoomReservation> getRooms() {
		return rooms;
	}

	public void setRooms(List<RoomReservation> rooms) {
		this.rooms = rooms;
	}

	public List<Float> getLst() {
		return lst;
	}

	public void setLst(List<Float> lst) {
		this.lst = lst;
	}

	

	

}
