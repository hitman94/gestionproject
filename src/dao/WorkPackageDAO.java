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
	
}
