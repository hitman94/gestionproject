package dao;

import javax.ejb.Stateless;
import javax.inject.Named;

import wpws.WorkSpace;


@Stateless
@Named
public class WorkSpaceDAO extends AbstractDAO<WorkSpace> {
	public WorkSpaceDAO() {
		super(WorkSpace.class,"WorkSpace");
	}
}
