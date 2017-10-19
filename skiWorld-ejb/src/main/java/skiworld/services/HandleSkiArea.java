package skiworld.services;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import skiworld.persistence.SkiArea;
import skiworld.persistence.SkiAreaType;


@Stateless
public class HandleSkiArea implements IHandleSkiArea{
	@PersistenceContext
	EntityManager em;

	@Override
	public void AddSkiArea (SkiArea skiarea) {
		em.persist(skiarea);
	}
	
	@Override
	public List<SkiArea> findAll() {
		return em.createQuery("select e from SkiArea e ").getResultList();
	}
	
	@Override
	public List<SkiArea> findDistinct() {
		return em.createQuery("select distinct e from SkiArea e ").getResultList();
	}
	
	
	
	
	@Override
	public List<Long> findStat() {
		return em.createQuery("select count(*) from SkiAreaType t join  t.skiArea s where s.skiAreaType.idType = t.idType group by t.idType").getResultList();
	}
	
	@Override
	public List<Long> findStat1() {
		return em.createQuery("Select count(e) from SkiArea e").getResultList();
	}	
	
	@Override
	public Boolean supprimerSkiArea(SkiArea skiarea) {
		// TODO Auto-generated method stub
		try{
			em.remove(em.merge(skiarea));
			}catch(Exception e){
				return false;
			}
			return true;
		
	}

	@Override
	public void modifierSkiArea(SkiArea skiarea) {
		em.merge(skiarea);
	}

	@Override
	public List<SkiAreaType> getAllPisteType() {
		try
		{
			Query query = em.createQuery("select p from SkiAreaType p");
			return query.getResultList();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
		
	}

	@Override
	public SkiAreaType findPisteTypeById(int id) {
		try
		{
			return em.find(SkiAreaType.class, id);
		}
		catch(Exception e)
		{}
		return null;
	}

	@Override
	public List<SkiArea> findPistsByTypes(SkiAreaType skiareaType) {
		return em
				.createQuery("select p from SkiArea p where p.SkiAreaType=:x", SkiArea.class)
				.setParameter("x", skiareaType)
				.getResultList();
	}

	
}

