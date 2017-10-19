package skiworld.services;

import java.util.List;
import javax.ejb.Local;
import skiworld.persistence.SkiAreaType;


@Local
public interface IHandleTypeSkiArea {

	void AddTypeSkiArea(SkiAreaType skiareatype);
	List<SkiAreaType> findAll();
	Boolean RemoveTypeSkiArea(SkiAreaType skiareatype);
	void UpdateTypeSkiArea(SkiAreaType skiareatype);

}
