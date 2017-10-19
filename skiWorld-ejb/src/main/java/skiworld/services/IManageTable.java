package skiworld.services;

import java.util.List;

import javax.ejb.Local;

import skiworld.persistence.Restaurant;
import skiworld.persistence.RestoTable;
@Local
public interface IManageTable {
	void addRestoTable (RestoTable restotable);
	List<RestoTable> findAllTables();
	void deleteTable (RestoTable restotable);
	void updateRestoTable (RestoTable restotable);
	void affectTableToRestaurant(Restaurant restaurant, RestoTable restoTable);
	RestoTable findRestoTable (int id);

}
