package skiworld.services;

import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import skiworld.persistence.Client;
import skiworld.persistence.EventHolder;
import skiworld.persistence.Instructor;
import skiworld.persistence.Player;
import skiworld.persistence.RestaurantManager;
import skiworld.persistence.SkiMan;
import skiworld.persistence.User;
import skiworld.persistence.Worker;

@Stateless
public class HandelUser implements IHandelUser {
	@PersistenceContext
	EntityManager em;

	@Override
	public void addSkiMan(SkiMan skiman) {
		em.persist(skiman);
	}

	@Override
	public void addInstructor(Instructor instructor) {
		em.persist(instructor);
	}

	@Override
	public void addEventHolder(EventHolder eventHolder) {
		em.persist(eventHolder);
	}

	@Override
	public void addPlayer(Player player) {
		em.persist(player);
	}

	@Override
	public void addWorker(Worker worker) {
		em.persist(worker);
	}

	@Override
	public void addRestaurantManager(RestaurantManager restaurantManager) {
		em.persist(restaurantManager);
	}

	@Override
	public List<User> getUser() {

		TypedQuery<User> querry = em.createQuery("select u from User u", User.class);
		return querry.getResultList();

	}

	@Override
	public List<Instructor> getInstructor() {

		TypedQuery<Instructor> querry = em.createQuery("select i from Instructor i", Instructor.class);
		return querry.getResultList();

	}

	@Override
	public void removeUser(User user) {
		em.remove(em.merge(user));

	}

	@Override
	public void updateUser(User user) {
		em.merge(user);

	}

	@Override
	public void addClient(Client client) {
		em.persist(client);

	}

	@Override
	public List<Worker> FindAllWorker() {
		TypedQuery<Worker> query=em.createQuery("Select w from Worker w", Worker.class);
		return query.getResultList();
	}

	@Override
	public void deleteWorker(Worker worker) {
		em.remove(em.merge(worker));
		
	}

	@Override
	public void updateWorker(Worker worker) {
		em.merge(worker);
		
	}

	@Override
	public boolean removeUserById(int id) {
		Iterator<User> iterator=getUser().iterator();
		while(iterator.hasNext()){
			User r=iterator.next();
			if(r.getIdUser()==id){
				em.remove(r);
				return true;
			}
		}
		return false;

	}

}
