package skiworld.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import skiworld.persistence.Admin;
import skiworld.persistence.Client;
import skiworld.persistence.Parking;
import skiworld.persistence.Room;
import skiworld.persistence.RoomReservation;
import skiworld.persistence.User;
@Local
public interface IGestionReservationLocal {

	void reserverRoom( Client client,Room room,Date arrivalDate,Date departureDate);
	public List<Float> priceReservation();
    public List<RoomReservation> getRoomReservation();
    public List<RoomReservation> getDistinctRoomReservation();
    void reserverParking( Client client, Parking parking,Date dateArrival,Date dateDeparture);
		
	
}
