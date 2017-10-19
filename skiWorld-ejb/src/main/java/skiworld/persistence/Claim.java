package skiworld.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Claim implements Serializable{
	private int idClaim;
	private String typeClaim;
	private String description;
	private User user;
	@Id
	public int getIdClaim() {
		return idClaim;
	}
	public void setIdClaim(int idClaim) {
		this.idClaim = idClaim;
	}
	public String getTypeClaim() {
		return typeClaim;
	}
	public void setTypeClaim(String typeClaim) {
		this.typeClaim = typeClaim;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@ManyToOne
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
