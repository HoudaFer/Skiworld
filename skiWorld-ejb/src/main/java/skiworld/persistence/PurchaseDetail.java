package skiworld.persistence;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PurchaseDetail implements Serializable {
	private PurchaseDetailPk purchaseDetailPk;
	private User user;
	private Product product;

	@EmbeddedId
	public PurchaseDetailPk getPurchaseDetailPk() {
		return purchaseDetailPk;
	}

	public void setPurchaseDetailPk(PurchaseDetailPk purchaseDetailPk) {
		this.purchaseDetailPk = purchaseDetailPk;
	}

	@ManyToOne
	@JoinColumn(name = "id_user", insertable = false, updatable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	@JoinColumn(name = "id_product", insertable = false, updatable = false)
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
