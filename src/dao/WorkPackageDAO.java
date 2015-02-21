package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;

import wpws.WorkPackage;



@Stateless
@Named
public class WorkPackageDAO extends AbstractDAO<WorkPackage>{

	public WorkPackageDAO() {
		super(WorkPackage.class, "WorkPackage");
	}
}
