package skiworld.services;

import java.util.List;

import javax.ejb.Local;

import skiworld.persistence.Parking;

@Local
public interface IParkingManagerLocal {
	void AddParking(Parking parking);
	void DeleteParking(Parking parking);
	void UpdateParking(Parking parking);
	List<Parking> getParkings();

}
