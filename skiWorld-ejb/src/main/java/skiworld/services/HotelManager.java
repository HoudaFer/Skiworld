package skiworld.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import skiworld.persistence.Hotel;
import skiworld.persistence.Room;

@Stateless
public class HotelManager implements IHotelManagerLocal {
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void addHotel(Hotel hotel){
		em.persist(hotel);
		
	}
	@Override
	public void DeleteHotel(Hotel hotel){
		em.remove(em.merge(hotel));
	}
   @Override
   public void UpdateHotel(Hotel hotel){
	   em.merge(hotel);
	   
   }
   @Override
   public void AddRoom(Room room){
	   em.persist(room);
   }
   @Override
   public void DeleteRoom(Room room){
		em.remove(em.merge(room)); 
   }
   @Override
   public void UpdateRoom(Room room){
	   em.merge(room);
   }
@Override
public List<Hotel> getHotels() {
	TypedQuery<Hotel> querry=em.createQuery("select h from Hotel h",Hotel.class);
	return querry.getResultList();
}
@Override
public List<Room>getRooms(){
	TypedQuery<Room> querry=em.createQuery("select r from Room r",Room.class);
	return querry.getResultList();
}
}
