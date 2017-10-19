package skiworld.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;
@Entity
public class Restaurant implements Serializable{
	private int idRestaurant;
	private String name;
	private String phone;
	private int starRating;
	private Date openDate;
	private Date closeDate;
	private String location;
	private List<RestoTable> restoTable;
	private List<Menu> menu;
@Id
@GeneratedValue(strategy=GenerationType.AUTO)

	public int getIdRestaurant() {
		return idRestaurant;
	}

	public void setIdRestaurant(int idRestaurant) {
		this.idRestaurant = idRestaurant;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getStarRating() {
		return starRating;
	}

	public void setStarRating(int starRating) {
		this.starRating = starRating;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@XmlTransient
@OneToMany(mappedBy="restaurant", fetch=FetchType.EAGER)
	public List<RestoTable> getTable() {
		return restoTable;
	}

	public void setTable(List<RestoTable> restoTable) {
		this.restoTable = restoTable;
	}
	
	@XmlTransient
@OneToMany(mappedBy="restaurant", fetch=FetchType.EAGER)
	public List<Menu> getMenu() {
		return menu;
	}

	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}

}
