package managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import skiworld.persistence.Hotel;
import skiworld.persistence.Room;
import skiworld.persistence.RoomType;
import skiworld.services.IHotelManagerLocal;

@ManagedBean
@ViewScoped
public class ListRoomBean {
	private Room room;
	private int numberRoom;
	private RoomType roomtype;
	private List<Room>rooms;
	private Boolean test1=false;
	@EJB
	private IHotelManagerLocal hotelManagerLocal;
	@PostConstruct
	public void init(){
		room=new Room();
		rooms=new ArrayList<>();
		rooms=hotelManagerLocal.getRooms();
	}
	public String delete (Room room){
		hotelManagerLocal.DeleteRoom(room);
		init();
		return null;
	}
	public String update(){
		System.out.println(room.getIdRoom());
		hotelManagerLocal.UpdateRoom(room);
		init();
		return null;
	}
	 public String inisialiser(){
		 test1=true;
		
		
		return null;
	}
	
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public int getNumberRoom() {
		return numberRoom;
	}
	public void setNumberRoom(int numberRoom) {
		this.numberRoom = numberRoom;
	}
	public RoomType getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(RoomType roomtype) {
		this.roomtype = roomtype;
	}
	public List<Room> getRooms() {
		return rooms;
	}
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	public IHotelManagerLocal getHotelManagerLocal() {
		return hotelManagerLocal;
	}
	public void setHotelManagerLocal(IHotelManagerLocal hotelManagerLocal) {
		this.hotelManagerLocal = hotelManagerLocal;
	}
	public Boolean getTest1() {
		return test1;
	}
	public void setTest1(Boolean test1) {
		this.test1 = test1;
	}
	

}
