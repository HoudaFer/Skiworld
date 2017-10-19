package skiworld.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import skiworld.persistence.SkiAreaType;


@Stateless
public class HandleTypeSkiArea implements IHandleTypeSkiArea{

	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void AddTypeSkiArea (SkiAreaType skiareatype) {
		em.persist(skiareatype);
	}
	
	@Override
	public List<SkiAreaType> findAll() {
		return em.createQuery("Select a from SkiAreaType a ").getResultList();
	}
	
	@Override
	public Boolean RemoveTypeSkiArea(SkiAreaType skiareatype) {
		try{
			em.remove(em.merge(skiareatype));
			}catch(Exception e){
				return false;
			}
			return true;
		
	}

	@Override
	public void UpdateTypeSkiArea(SkiAreaType skiareatype) {
		em.merge(skiareatype);
	}

	
	
}
