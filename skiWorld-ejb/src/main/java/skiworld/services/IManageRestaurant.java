package skiworld.services;

import java.util.List;

import javax.ejb.Local;

import skiworld.persistence.Restaurant;

@Local
public interface IManageRestaurant {
	void addRestaurant (Restaurant restaurant);
	List<Restaurant> FindRestaurant();
	void deleteRestaurant (Restaurant restaurant);
	Boolean updateRestaurant (Restaurant restaurant);
	Restaurant findRestaurant (int id);
	boolean deleteRestaurantById(int id);
}
