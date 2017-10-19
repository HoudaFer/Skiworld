package skiworld.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import skiworld.persistence.Parking;

@Stateless
public class ParkingManager implements IParkingManagerLocal {
	@PersistenceContext
	EntityManager em;

	@Override
	public void AddParking(Parking parking) {
	em.persist(parking);
		
	}

	@Override
	public void DeleteParking(Parking parking) {
	em.remove(em.merge(parking));
		
	}

	@Override
	public void UpdateParking(Parking parking) {
		em.merge(parking);
		
	}

	@Override
	public List<Parking> getParkings() {
	TypedQuery<Parking> querry=em.createQuery("select p from Parking p",Parking.class);
		return querry.getResultList();
	}

}
