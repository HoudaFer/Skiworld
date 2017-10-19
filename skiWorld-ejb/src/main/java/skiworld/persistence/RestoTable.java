package skiworld.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class RestoTable implements Serializable{
	private int idTable;
	private int chairsNumber;
	private int tablesNumber;
	private boolean isAvailable;
	private Restaurant restaurant ;
	private User user ;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	public int getIdTable() {
		return idTable;
	}
	public void setIdTable(int idTable) {
		this.idTable = idTable;
	}
	public int getChairsNumber() {
		return chairsNumber;
	}
	public void setChairsNumber(int chairsNumber) {
		this.chairsNumber = chairsNumber;
	}
	public int getTablesNumber() {
		return tablesNumber;
	}
	public void setTablesNumber(int tablesNumber) {
		this.tablesNumber = tablesNumber;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	@ManyToOne
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@ManyToOne
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	
}
