package skiworld.services;

import java.util.Date;

import javax.ejb.Local;

import skiworld.persistence.Admin;
import skiworld.persistence.Client;
import skiworld.persistence.RestoTable;
@Local
public interface IManageTableReservation {
	void reserveRestoTable (Client client, RestoTable restotable, Date StartTime, Date EndTime);
}
