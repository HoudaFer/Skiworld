package skiworld.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import skiworld.persistence.Instructor;
import skiworld.persistence.Planing;
import skiworld.persistence.User;

@Stateless
public class HandlePlaning implements IHandlePlaning{
	@PersistenceContext
	EntityManager em;
	

	@Override
	public void addPlaning(Planing planing) {
		em.persist(planing);
	}


	@Override
	public void deletePlaning(Planing planing) {
	em.remove(em.merge(planing));
		
	}


	@Override
	public List<Planing> getPlaning() {
		TypedQuery<Planing> querry = em.createQuery("select p from Planing  p", Planing.class);
		return querry.getResultList();
	}

	
}
