package skiworld.services;

import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import skiworld.persistence.Restaurant;
@Stateless
public class ManageRestaurant implements IManageRestaurant {
	@PersistenceContext
	EntityManager em;

	@Override
	public void addRestaurant(Restaurant restaurant) {
		em.persist(restaurant);
		
	}

	@Override
	public List<Restaurant> FindRestaurant() {
		TypedQuery<Restaurant> query=em.createQuery("Select r from Restaurant r", Restaurant.class);
		return query.getResultList();
	}

	@Override
	public void deleteRestaurant(Restaurant restaurant) {
		em.remove(em.merge(restaurant));
		
	}

	@Override
	public Boolean updateRestaurant(Restaurant restaurant) {
		try{
			
			em.merge(restaurant);
			}catch(Exception e){
				return false;
			}
			return true;
		
	}

	@Override
	public Restaurant findRestaurant(int id) {
		Restaurant r =em.find(Restaurant.class, id);
		return r;
	}

	@Override
	public boolean deleteRestaurantById(int id) {
		Iterator<Restaurant> iterator=FindRestaurant().iterator();
		while(iterator.hasNext()){
			Restaurant r = iterator.next();
			if(r.getIdRestaurant()==id){
				em.remove(r);
				return true;
			}
			}
		return false;
		}
		
	
	}
	

	
