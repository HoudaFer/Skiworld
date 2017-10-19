package skiworld.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import skiworld.persistence.Menu;
import skiworld.persistence.Restaurant;

@Stateless
public class ManageMenu implements IManageMenu {
	@PersistenceContext
	EntityManager em;

	@Override
	public void addMenu(Menu menu) {
		em.persist(menu);
		
	}

	@Override
	public List<Menu> FindMenu() {
		TypedQuery<Menu> query=em.createQuery("Select m from Menu m", Menu.class);
		return query.getResultList();
	}

	@Override
	public void deleteMenu(Menu menu) {
		em.remove(em.merge(menu));
		
	}

	@Override
	public void updateMenu(Menu menu) {
		em.merge(menu);
		
	}

	@Override
	public void affectMenuToRestaurant(Restaurant restaurant, Menu menu) {
		menu.setRestaurant(restaurant);
		em.persist(menu);
		
		
	}

	@Override
	public Menu findMenu(int id) {
		Menu m =em.find(Menu.class,id);
		return m;
	}

}
