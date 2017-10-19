package skiworld.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import skiworld.persistence.Player;

/**
 * Session Bean implementation class PlayerService
 */
@Stateless
@LocalBean
public class PlayerService implements  PlayerServiceLocal {

	@PersistenceContext
	EntityManager em;
	
    public PlayerService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void ajouterPlayer(Player player) {
		// TODO Auto-generated method stub
		em.persist(player);
		
	}


	@Override
	public void modifierPlayer(Player player) {
		// TODO Auto-generated method stub
		em.merge(player);
		
	}

	@Override
	public Boolean supprimerPlayer(Player player) {
		// TODO Auto-generated method stub
		try{
			em.remove(em.merge(player));
			}catch(Exception e){
				return false;
			}
			return true;
	}

	@Override
	public List<Player> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("Select e from Player e ").getResultList();
	}

}
