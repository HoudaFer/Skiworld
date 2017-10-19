package managedBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import skiworld.persistence.Admin;
import skiworld.persistence.Client;
import skiworld.persistence.EventHolder;
import skiworld.persistence.Instructor;
import skiworld.persistence.SkiMan;
import skiworld.persistence.User;
import skiworld.services.IManageUsers;

@ManagedBean
@SessionScoped
public class AuthenticationBean {
	private String login;
	private String password;
	private User user;
	@EJB
	private IManageUsers imaManageUsers;

	public String login() {
	  user = imaManageUsers.authetifier(login, password);
		if (user!=null){
			if (user instanceof Admin){ return "addUser";}
			else if (user instanceof SkiMan) {
			return "welcomeSkiMan";}
			else if (user instanceof Instructor){
			return "welcomeInstructor";}
			else if (user instanceof EventHolder){ 
			return "welcomeEventHolder";}
			else if (user instanceof Client){ 
				return "resClient";}
			return null;
		}
		return "login";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public IManageUsers getImaManageUsers() {
		return imaManageUsers;
	}

	public void setImaManageUsers(IManageUsers imaManageUsers) {
		this.imaManageUsers = imaManageUsers;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	
	
}
