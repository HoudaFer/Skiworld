package skiworld.services;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import skiworld.persistence.Admin;
import skiworld.persistence.Client;
import skiworld.persistence.RestoTable;
import skiworld.persistence.RestoTableReservation;
import skiworld.persistence.RestoTableReservationPk;

@Stateless
public class ManageTableReservation implements IManageTableReservation{
	@PersistenceContext
	EntityManager em;
	@Override
	public void reserveRestoTable(Client client, RestoTable restotable, Date startTime, Date endTime) {
		RestoTableReservationPk pk = new RestoTableReservationPk();
		pk.setId_user(client.getIdUser());
		pk.setId_table(restotable.getIdTable());
		pk.setStartTime(startTime);
		pk.setEndTime(endTime);
		RestoTableReservation tableReservation = new RestoTableReservation();
		tableReservation.setRestoTableReservationPk(pk);
		em.persist(tableReservation);
	}

}
