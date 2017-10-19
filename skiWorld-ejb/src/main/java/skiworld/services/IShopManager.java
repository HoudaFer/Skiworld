package skiworld.services;

import java.util.List;

import javax.ejb.Local;


import skiworld.persistence.Category;
import skiworld.persistence.Product;
import skiworld.persistence.Shop;




@Local
public interface IShopManager {
//product
	void AddProduct (Product product);
	  
	  void DeleteProduct (Product product);
	  void UpdateProduct (Product product);
	  boolean deleteProductById(int id);

	  void affectProductToCategory (Category category , Product product);
	  Product findProduct (int id);
	//List<Product> FindProductByName(String name);
	  List<Product> ListProduct();
	
//Category
	  void AddCategory (Category category);
	  void DeleteCategory (Category category);
	  void UpdateCategory (Category category);
	 
	  Product findCategory (int id);
	//List<Product> FindProductByName(String name);
	  List<Category> ListCategory();
	   List<Product> ListProductByCategory() ;
			
	  List<Shop> ListShop();	
	  List<Product> ListProductPrice ();
}
