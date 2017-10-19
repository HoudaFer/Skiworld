package managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import skiworld.persistence.Restaurant;
import skiworld.persistence.RestoTable;
import skiworld.services.IManageRestaurant;
import skiworld.services.IManageTable;

@ManagedBean
@ViewScoped
public class RestoTableBean {
	
	private int idTable;
	private int chairsNumber;
	private int tablesNumber;
	private boolean isAvailable;
	private RestoTable restotable;
	private List<RestoTable> restotables;
	private Boolean renderUpdateForm = false;
	private Restaurant restaurant;
	private List<Restaurant> restaurants;
	@EJB
	private IManageRestaurant manageresto;

	@EJB
	private IManageTable managetable;
	
	public String addingRestoTable() {
		//RestoTable restotable =new RestoTable();
	
		restotable.setChairsNumber(chairsNumber);
		restotable.setTablesNumber(tablesNumber);
		restotable.setAvailable(isAvailable);
		managetable.addRestoTable(restotable);
		restotables=managetable.findAllTables();
		restotable = new RestoTable();
		restotable.setRestaurant(new Restaurant());
		
		//managetable.addRestoTable(restotable);
		return "welcome2";
	}
	
	@PostConstruct
	public void init(){ 
		restotable =new RestoTable();
		restotables = new ArrayList<>();
		restotables=managetable.findAllTables();
		restotable.getIdTable();
		restotable.getChairsNumber();
		restotable.getTablesNumber();	
		restaurants= new ArrayList<>();
		restaurants=manageresto.FindRestaurant();
		restotable.setRestaurant(new Restaurant());
	}
	
	public String deletingTable(RestoTable restotable) {
		managetable.deleteTable(restotable);
		init();
		return null;
	}
	
	public String updateRestoTable() {
		
		managetable.updateRestoTable(restotable);
		return null ;
	}
	
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
	public IManageTable getManagetable() {
		return managetable;
	}

	public void setManagetable(IManageTable managetable) {
		this.managetable = managetable;
	}

	public RestoTable getRestotable() {
		return restotable;
	}

	public void setRestotable(RestoTable restotable) {
		this.restotable = restotable;
	}

	public List<RestoTable> getRestotables() {
		return restotables;
	}

	public void setRestotables(List<RestoTable> restotables) {
		this.restotables = restotables;
	}

	public Boolean getRenderUpdateForm() {
		return renderUpdateForm;
	}

	public void setRenderUpdateForm(Boolean renderUpdateForm) {
		this.renderUpdateForm = renderUpdateForm;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	public IManageRestaurant getManageresto() {
		return manageresto;
	}

	public void setManageresto(IManageRestaurant manageresto) {
		this.manageresto = manageresto;
	}
	
	
	
}
