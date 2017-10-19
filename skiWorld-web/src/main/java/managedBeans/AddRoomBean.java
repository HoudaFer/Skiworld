package managedBeans;



import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import skiworld.persistence.Hotel;
import skiworld.persistence.Room;
import skiworld.persistence.RoomType;
import skiworld.services.IHotelManagerLocal;

@ManagedBean
@RequestScoped
public class AddRoomBean {
	@EJB
	private IHotelManagerLocal hotelManagerLocal;
	private int numberRoom;
	private RoomType type;
    private Hotel hotel;
    private List<Hotel>hotels;
    private Room room;
    private List<Room>Rom;
    
    @ManagedProperty(value="#{roomService}")
    private roomService rooms;
    
    
	@PostConstruct
	public void init(){
		hotel=new Hotel();
		hotels=new ArrayList<>();
		hotels =rooms.getHotels();
		 
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

	public String addRoom() {
		Room room = new Room();
		room.setNumberRoom(numberRoom);
		room.setRoomType(type);
		room.setHotel(hotel);
		
		hotelManagerLocal.AddRoom(room);
		return "ListRoom";

	}

	public IHotelManagerLocal getHotelManagerLocal() {
		return hotelManagerLocal;
	}

	public void setHotelManagerLocal(IHotelManagerLocal hotelManagerLocal) {
		this.hotelManagerLocal = hotelManagerLocal;
	}

	public int getNumberRoom() {
		return numberRoom;
	}

	public void setNumberRoom(int numberRoom) {
		this.numberRoom = numberRoom;
	}

	public RoomType getType() {
		return type;
	}

	public void setType(RoomType type) {
		this.type = type;
	}
	public roomService getRooms() {
		return rooms;
	}
	public void setRooms(roomService rooms) {
		this.rooms = rooms;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public List<Room> getRom() {
		return Rom;
	}
	public void setRom(List<Room> rom) {
		Rom = rom;
	}
	

}
