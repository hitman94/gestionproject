package dao;

import entreprise.Department;

public class DepartmentDAO extends AbstractStructureDAO<Department> {
	public DepartmentDAO() {
		super(Department.class,"Department");
	}
}
