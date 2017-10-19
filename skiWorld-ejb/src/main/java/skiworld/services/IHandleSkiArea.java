package skiworld.services;

import java.util.List;

import javax.ejb.Local;
import skiworld.persistence.SkiArea;
import skiworld.persistence.SkiAreaType;

@Local
public interface IHandleSkiArea {
	
	
	void AddSkiArea(SkiArea skiarea);
	List<SkiArea> findAll();
	Boolean supprimerSkiArea(SkiArea skiarea);
	void modifierSkiArea(SkiArea skiarea);
	public List<SkiAreaType> getAllPisteType();
	public SkiAreaType findPisteTypeById(int id);
	public List<SkiArea> findPistsByTypes(SkiAreaType skiareaType);
	List<Long> findStat();
	List<SkiArea> findDistinct();
	List<Long> findStat1();
	
	
}
