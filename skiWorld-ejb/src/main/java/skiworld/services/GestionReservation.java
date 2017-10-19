package skiworld.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import skiworld.persistence.Room;
import skiworld.persistence.RoomReservation;
import skiworld.persistence.RoomReservationPk;
import skiworld.persistence.User;
import skiworld.persistence.Admin;
import skiworld.persistence.Client;
import skiworld.persistence.Parking;
import skiworld.persistence.ParkingReservation;
import skiworld.persistence.ParkingReservationPk;
@Stateless
public class GestionReservation implements IGestionReservationLocal {
	@PersistenceContext
	EntityManager em;

	@Override
	public void reserverRoom(Client client,Room room, Date arrivalDate, Date departureDate ) {
		RoomReservationPk pk=new RoomReservationPk();
	    //pk.setId_user(client.getCin());
		System.out.println("admin  : " + client);
		pk.setId_user(client.getIdUser());
	    pk.setId_room(room.getIdRoom());
	    pk.setArrivalDate(arrivalDate);
	    pk.setDepartureDate(departureDate);
	    
	    RoomReservation roomReservation=new RoomReservation();
	    roomReservation.setRoomReservationPk(pk);
	    
	    em.persist(roomReservation);
	}
	@Override
	public void reserverParking(Client client,Parking parking,Date dateArrival,Date dateDeparture){
		ParkingReservationPk pk=new ParkingReservationPk();
		pk.setId_user(client.getIdUser());
		pk.setId_parking(parking.getIdParking());
		pk.setDateArrival(dateArrival);
		pk.setDateDeparture(dateDeparture);
		
		ParkingReservation parkingReservation=new ParkingReservation();
		parkingReservation.setParkingReservationPk(pk);
		em.persist(parkingReservation);
	}

	@Override
	public List<Float> priceReservation() {
	Query querry=em.createQuery("select distinct sum(rr.price) from RoomReservation rr inner join rr.room r where rr.roomReservationPk.id_room = r.idRoom and rr.isCheck = 0 group by r.hotel.idHotel");
	List<Float> lst= (List<Float>)querry.getResultList();
	return lst;
	}

	@Override
	public List<RoomReservation> getRoomReservation() {
		
			TypedQuery<RoomReservation> querry=em.createQuery("select r from RoomReservation r",RoomReservation.class);
			return querry.getResultList();
		}

	@Override
	public List<RoomReservation> getDistinctRoomReservation() {
		TypedQuery<RoomReservation> querry=em.createQuery("select distinct r from RoomReservation r",RoomReservation.class);
		return querry.getResultList();
		

	
	}	

	

}
