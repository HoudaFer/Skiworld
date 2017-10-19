package skiworld.services;

import javax.ejb.Local;

import skiworld.persistence.User;
@Local
public interface IManageUsers {
	User authetifier(String login,String password);
}
