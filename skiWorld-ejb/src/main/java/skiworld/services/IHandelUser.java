package skiworld.services;

import java.util.List;

import javax.ejb.Local;

import skiworld.persistence.Client;
import skiworld.persistence.EventHolder;
import skiworld.persistence.Instructor;
import skiworld.persistence.Planing;
import skiworld.persistence.Player;
import skiworld.persistence.RestaurantManager;
import skiworld.persistence.SkiMan;
import skiworld.persistence.User;
import skiworld.persistence.Worker;
@Local
public interface IHandelUser {
	void addSkiMan(SkiMan skiman);
	void removeUser(User user);
	void updateUser(User user);
	void addInstructor(Instructor instructor);
	void addEventHolder(EventHolder eventHolder);
	void addPlayer(Player player);
	void addWorker(Worker worker);
	List<Worker> FindAllWorker();
	void deleteWorker (Worker worker);
	void updateWorker (Worker worker);
	void addRestaurantManager(RestaurantManager restaurantManager);
	void addClient(Client client);
	List<User> getUser();
    List<Instructor> getInstructor();
    boolean removeUserById(int id);
    
}
