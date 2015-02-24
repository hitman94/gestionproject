package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import utilisateur.User;
import wpws.WorkPackage;
import entreprise.Entreprise;



@Stateless
@Named
public class WorkPackageDAO extends AbstractDAO<WorkPackage>{

	public WorkPackageDAO() {
		super(WorkPackage.class, "WorkPackage");
	}
	
	public List<WorkPackage> getWpFromCompany(Long entId) {
		Query q = em.createQuery("SELECT w FROM WorkPackage w WHERE w.assignedTo.ent.id=:id");
		q.setParameter("id", entId);
		try {
			List<WorkPackage> result = q.getResultList();
			return result;
		} catch (NoResultException e) {
			return null;
		} 
	}
}
