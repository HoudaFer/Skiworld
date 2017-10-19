package skiworld.persistence;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Picture extends Gallery{

	private String picture ;
	private User user;
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	@ManyToOne
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
