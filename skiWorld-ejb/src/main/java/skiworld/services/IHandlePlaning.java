package skiworld.services;

import java.util.List;

import javax.ejb.Local;

import skiworld.persistence.Instructor;
import skiworld.persistence.Planing;

@Local
public interface IHandlePlaning {
	void addPlaning(Planing planing);
	void deletePlaning(Planing planing);
	List<Planing> getPlaning();
}
