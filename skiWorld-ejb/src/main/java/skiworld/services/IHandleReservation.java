package skiworld.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import skiworld.persistence.Admin;
import skiworld.persistence.SkiArea;


@Local
public interface IHandleReservation {

	void ReserverSkiArea(Admin admin, SkiArea skiarea, Date reservationDate);
	public List<SkiArea> findBYDate(Date dateDebut); 

}
