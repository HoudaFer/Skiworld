package managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import skiworld.persistence.Menu;
import skiworld.persistence.Restaurant;
import skiworld.services.IManageMenu;
import skiworld.services.IManageRestaurant;

@ManagedBean
@ViewScoped
public class MenuBean {

	private String name;
	private int orderNumber;
	private boolean isAvailable;
	private float price;
	private Menu menu;
	private Restaurant restaurant;
	private List<Menu> menus;
	private List<Restaurant> restaurants;
	private Boolean renderUpdateForm = false;
	@EJB
	private IManageRestaurant managerestau;
	@EJB
	private IManageMenu manageMenu;
	
	public String addingMenu() {

		menu.setName(name);
		menu.setOrderNumber(orderNumber);
		menu.setAvailable(isAvailable);
		menu.setPrice(price);
		manageMenu.addMenu(menu);
		menus=manageMenu.FindMenu();
		menu = new Menu();
		menu.setRestaurant(new Restaurant());
		return "welcome2";
	}
	
	@PostConstruct
	public void init(){ 
		
		menu= new Menu();
		menus= new ArrayList<>();
		menus=manageMenu.FindMenu();
		menu.getName();
		menu.getOrderNumber();
		menu.getPrice();
		restaurants= new ArrayList<>();
		restaurants=managerestau.FindRestaurant();
		menu.setRestaurant(new Restaurant());		
	}
	
	public String delete(Menu menu) {
		manageMenu.deleteMenu(menu);
		init();
		return null;
	}
	
	public String updateMenu() {
		
		manageMenu.updateMenu(menu);
		return null ;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public IManageMenu getManageMenu() {
		return manageMenu;
	}
	public void setManageMenu(IManageMenu manageMenu) {
		this.manageMenu = manageMenu;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
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

	public IManageRestaurant getManagerestau() {
		return managerestau;
	}

	public void setManagerestau(IManageRestaurant managerestau) {
		this.managerestau = managerestau;
	}

	
	}
