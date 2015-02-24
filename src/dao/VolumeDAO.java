package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import livre.Chapter;
import livre.Volume;
import utilisateur.User;


@Stateless
@Named
public class VolumeDAO  extends AbstractDAO<Volume>{

	public VolumeDAO() {
			super(Volume.class,"Volume");
	}
	
	public List<Chapter> volumeFromEntreprise(Long id) {
		Query q = em.createQuery("SELECT v FROM Volume v WHERE v.wp.assignedTo.ent.id=:id");
		q.setParameter("id", id);
		try {
			List<Chapter> result = q.getResultList();
			return result;
		} catch (NoResultException e) {
			return null;
		} 
	}
}
