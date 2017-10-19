package managedBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import skiworld.persistence.Category;
import skiworld.persistence.Product;
import skiworld.persistence.Shop;
import skiworld.services.IShopManager;




@ManagedBean

@ViewScoped
public class manageCategoryBean {
	private String name ;
	private Shop shop;
	private Category category ;
	 @EJB
		IShopManager shopManager1;


	
	Category c =new Category();
		private List<Category> Categorys ;
		private List<Shop> Shops;
		 private Boolean test=false;
		 private Boolean test2=false;
		 private Boolean test3=false;
		 public String addCategory(){
			//Category category = new Category();
		   // category.setName(name);
			//shopManager1.AddCategory(category);
			//return "/Shop/ListCategory?faces-redirect=true";
			
			
			
			String navigateTo1 =  "/Shop/ListCategory?faces-redirect=true";
			category.setName(name);
		
			
			
			shopManager1.AddCategory(category);
			Categorys=shopManager1.ListCategory();
			category = new Category();
			category.setShop(new Shop());
			return navigateTo1;
			
		}
		 
		 @PostConstruct
	     public void init(){
			 category =new Category();
		Categorys=shopManager1.ListCategory();
		
		category.setShop(new Shop());
		test=false;
		test2=false;
		setTest3(false);
	}
		 public String delete(Category category){
			 
			 shopManager1.DeleteCategory(category);
				init();
		        return null;
		 }
		 
		 public String updateCategory(){
			 
			  System.out.println(category.getIdCategory());
			 
			
			 
			   
			    shopManager1.UpdateCategory(category);
			
				
				
				 setTest2(false);
					init();
					
					return null ;
				
						
		 }
		 
		 public void prepareCreate() {
				init();
				setTest(true);

			}
		 public void prepareEdit(Category prod) {
				category = prod;
				setTest2(true);

			}
		 public String inisialiser(){
			 test=true;
			
			
			return null;
		}
		
		public String inisialiser2(){
			 test2=true;
			
			
			return null;
		}
		

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		public List<Category> getCategorys() {
			return Categorys;
		}

		public void setCategorys(List<Category> categorys) {
			Categorys = categorys;
		}

		public Boolean getTest() {
			return test;
		}

		public void setTest(Boolean test) {
			this.test = test;
		}

		public Boolean getTest2() {
			return test2;
		}

		public void setTest2(Boolean test2) {
			this.test2 = test2;
		}

		public Boolean getTest3() {
			return test3;
		}

		public void setTest3(Boolean test3) {
			this.test3 = test3;
		}
		 
		public Shop getShop() {
			return shop;
		}

		public void setShop(Shop shop) {
			this.shop = shop;
		}

		public List<Shop> getShops() {
			return Shops;
		}

		public void setShops(List<Shop> shops) {
			Shops = shops;
		}

		public List<Shop> shops(){
			return Shops = shopManager1.ListShop();
		}

		public Category getC() {
			return c;
		}

		public void setC(Category c) {
			this.c = c;
		}

		public IShopManager getShopManager1() {
			return shopManager1;
		}

		public void setShopManager1(IShopManager shopManager1) {
			this.shopManager1 = shopManager1;
		} 
	
}


