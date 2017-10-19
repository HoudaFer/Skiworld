package skiworld.persistence;

import java.io.Serializable;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Category implements Serializable{
	private int idCategory;
	private String name ;
	private Shop shop;
	
	private List<Product> product;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	private static final long serialVersionUID = 1L;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(mappedBy="category" ,fetch=FetchType.EAGER )
	
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	@ManyToOne
	@JoinColumn(name="fk_Shop")
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public Category() {
	
	}
	public Category(String name, Shop shop) {
	
		
		this.name = name;
		this.shop = shop;
	}
	
}
