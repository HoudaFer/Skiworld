package skiworld.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import skiworld.persistence.User;

@Stateless
public class ManageUsers implements IManageUsers {
	@PersistenceContext
	EntityManager em;

	@Override
	public User authetifier(String login, String password) {
		TypedQuery<User> querry = em
				.createQuery("Select u from User u where u.login=:login and u.password=:password", User.class);
		querry.setParameter("login",login);
		querry.setParameter("password",password);
		return querry.getSingleResult();
	}

}
