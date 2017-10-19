package managedBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;


import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;

import skiworld.persistence.Category;
import skiworld.persistence.Product;
import skiworld.services.IShopManager;






@ManagedBean

@ViewScoped
public class manageShopBean {
	private  String name ;
	private float price ;
	private boolean isAvailable ;
	private Category category;
//private int idCategory ;
	private Product product ;
	
	 @EJB
		IShopManager shopManager;
	

	 
	 Product p =new Product();
		private List<Product> Products ;
		private List<Category> categorys;
		
		private Boolean test=false;
		 private Boolean test2=false;
		 private Boolean test3=false;
		 
			
			
		 public String addProduct(){

			// Product product = new Product();
				//product.setName(name);
			//	product.setPrice(price);
			//	product.setIsAvailable(isAvailable);
			//	product.setCategory(category);
			//	shopManager.AddProduct(product);
			
			//	return "/Shop/ListProduct?faces-redirect=true";
				
				String navigateTo =  "/Shop/ListProduct?faces-redirect=true";
				product.setName(name);
				product.setPrice(price);
				product.setIsAvailable(isAvailable);
				
				shopManager.AddProduct(product);
				Products=shopManager.ListProduct();
				product = new Product();
				product.setCategory(new Category());
				
			return navigateTo;
		}
		 
	
		@PostConstruct
	     public void init(){
		product =new Product();
		Products=shopManager.ListProduct();
		//a tester
		product.setCategory(new Category());
		test=false;
		test2=false;
		setTest3(false);
		
		//to do  product.setCategory(new Category());
	}
		 public String delete(Product product){
			 
			 shopManager.DeleteProduct(product);
				init();
		        return null;
		 }
		 
		 public String updateProduct(){
			  // Product product = shopManager.findProduct(id);
			  System.out.println(product.getIdProduct());
			   // p.setName(name);
			  //  p.setPrice(price);
			  //  p.setIsAvailable(isAvailable);
			
			 
			   
			    shopManager.UpdateProduct(product);
			    setTest2(false);
				init();
				
				return null ;
				
				
				
			
				
				
						
		 }
		 public void prepareCreate() {
				init();
				setTest(true);

			}
		 public void prepareEdit(Product prod) {
				product = prod;
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
		public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price = price;
		}
		public boolean isAvailable() {
			return isAvailable;
		}
		public void setAvailable(boolean isAvailable) {
			this.isAvailable = isAvailable;
		}
		public Product getP() {
			return p;
		}
		public void setP(Product p) {
			this.p = p;
		}
		public List<Product> getProducts() {
			return Products;
		}
		public void setProducts(List<Product> products) {
			Products = products;
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
		public Product getProduct() {
			return product;
		}
		public void setProduct(Product product) {
			this.product = product;
		}
		public Category getCategory() {
			return category;
		}
		public void setCategory(Category category) {
			this.category = category;
		}



		public List<Category> getCategorys() {
			return categorys;
		}



		public void setCategorys(List<Category> categorys) {
			this.categorys = categorys;
		}
		public List<Category> categorys(){
			return categorys = shopManager.ListCategory();
		}



		public IShopManager getShopManager() {
			return shopManager;
		}



		public void setShopManager(IShopManager shopManager) {
			this.shopManager = shopManager;
		}





		
		
}
