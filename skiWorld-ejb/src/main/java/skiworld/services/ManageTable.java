package skiworld.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import skiworld.persistence.Restaurant;
import skiworld.persistence.RestoTable;
@Stateless
public class ManageTable implements IManageTable{
	@PersistenceContext
	EntityManager em;

	@Override
	public void addRestoTable(RestoTable restotable) {
		em.persist(restotable);
	}

	@Override
	public List<RestoTable> findAllTables() {
		TypedQuery<RestoTable> query=em.createQuery("Select r from RestoTable r", RestoTable.class);
		return query.getResultList();
	}

	@Override
	public void deleteTable(RestoTable restotable) {
		em.remove(em.merge(restotable));
		
	}

	@Override
	public void updateRestoTable(RestoTable restotable) {
		em.merge(restotable);
		
	}

	@Override
	public void affectTableToRestaurant(Restaurant restaurant, RestoTable restoTable) {
		restoTable.setRestaurant(restaurant);
		em.persist(restoTable);
		
	}

	@Override
	public RestoTable findRestoTable(int id) {
		RestoTable r = em.find(RestoTable.class, id);
		return r;
	}

	

}
