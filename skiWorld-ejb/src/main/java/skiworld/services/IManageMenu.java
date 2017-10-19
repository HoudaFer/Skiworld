package skiworld.services;

import java.util.List;

import javax.ejb.Local;

import skiworld.persistence.Menu;
import skiworld.persistence.Restaurant;

@Local
public interface IManageMenu {

	void addMenu (Menu menu);
	List<Menu> FindMenu();
	void deleteMenu (Menu menu);
	void updateMenu (Menu menu);
	void affectMenuToRestaurant (Restaurant restaurant,Menu menu);
	Menu findMenu (int id);
}
