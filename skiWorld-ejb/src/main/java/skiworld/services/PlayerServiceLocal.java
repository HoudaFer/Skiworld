package skiworld.services;

import java.util.List;

import javax.ejb.Local;

import skiworld.persistence.Player;

@Local
public interface PlayerServiceLocal {
	
	void ajouterPlayer(Player player);
	Boolean supprimerPlayer(Player player);
	void modifierPlayer (Player player);
	List<Player> findAll();

}
