package skiworld.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import skiworld.persistence.Admin;
import skiworld.persistence.SkiArea;
import skiworld.persistence.SkiAreaReservation;
import skiworld.persistence.SkiAreaReservationPk;

@Stateless
public class HandleReservation implements IHandleReservation{
	
	
@PersistenceContext
EntityManager em;


@Override
public void ReserverSkiArea(Admin admin, SkiArea skiarea, Date reservationDate )
{
	SkiAreaReservationPk pk = new SkiAreaReservationPk(admin.getIdUser(), skiarea.getIdArea(), reservationDate);
	SkiAreaReservation reservation = new SkiAreaReservation(pk , admin, skiarea, reservationDate);
	em.persist(reservation);
}


	@Override
	public List<SkiArea> findBYDate(Date dateDebut) {
//		 Query 
//		 List<SkiArea> areas = q.getResultList();
//		 q = em.createQuery("select a from SkiAreaReservation a "
//		 		+ "where YEAR( a.skiAreaReservationPk.reservationDate) = YEAR(:dateDebut) "
//		 		+ "and Month(  a.skiAreaReservationPk.reservationDate) = Month(:dateDebut) and Day(  a.skiAreaReservationPk.reservationDate) = Day(:dateDebut)");
        Query q = em.createQuery("select distinct(a) "
        			+	"from SkiAreaReservation s "	
        			+	"join s.skiArea a "
        			+	"where s.skiAreaReservationPk.reservationDate <= :date");
		 q.setParameter("date", dateDebut, TemporalType.DATE);
		 List<SkiArea> res1 = q.getResultList();
		 
		 q = em.createQuery("select d from SkiArea d ");
		 List<SkiArea> list2 = q.getResultList();
		 List<SkiArea> res = new ArrayList<>();
		 for (SkiArea skiArea : list2) {
			if(!res1.contains(skiArea))
			{
				res.add(skiArea);
			}
		}	
		 
		 return res;
	}
}
