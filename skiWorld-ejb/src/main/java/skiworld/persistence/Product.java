package skiworld.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product implements  Serializable {
	private int idProduct;
	private String name;
	private float price;
	private boolean isAvailable;
	private Category category;
	private List<PurchaseDetail> purchaseDetail;

	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO) 
	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
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
	private static final long serialVersionUID = 1L;
	public boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@ManyToOne
	@JoinColumn(name="Category_Fk")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
@OneToMany(mappedBy="product")
	public List<PurchaseDetail> getPurchaseDetail() {
		return purchaseDetail;
	}

	public void setPurchaseDetail(List<PurchaseDetail> purchaseDetail) {
		this.purchaseDetail = purchaseDetail;
	}

	public Product() {
		
	}

	public Product(String name, float price, boolean isAvailable, Category category) {
		super();
		this.name = name;
		this.price = price;
		this.isAvailable = isAvailable;
		this.category = category;
	}

	

}
