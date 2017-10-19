package skiworld.services;

import java.util.List;

import javax.ejb.Local;

import skiworld.persistence.Hotel;
import skiworld.persistence.Room;

@Local
public interface IHotelManagerLocal {
	void addHotel(Hotel hotel);
	void DeleteHotel(Hotel hotel);
    void UpdateHotel(Hotel hotel);
	
    void AddRoom(Room room);
	void DeleteRoom(Room room);
	void UpdateRoom(Room room);
	List<Hotel> getHotels();
	
	List<Room> getRooms();
	
    

}
