package entreprise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.persistence.Entity;

import utilisateur.User;

@Entity
public class Entreprise extends AbstractStructure {

	private Map<String, Department> childrenStructures;

	public Entreprise(String name) {
		super(name);
		this.childrenStructures = new HashMap<String, Department>();
	}

	public Entreprise(String name, User chief) {
		super(name, chief);
		this.childrenStructures = new HashMap<String, Department>();
	}
	
	/*
	 * Renvoie le Department correspondant au nom donné en paramètre.
	 */
	public Department getDepartment(String name) {
		return childrenStructures.get(name);
	}
	
	/*
	 * Renvoie la liste de Department.
	 */
	public List<Department> getDepartments() {
		return new ArrayList<Department>(childrenStructures.values());
	}

	@Override
	public AbstractStructure getParent() {
		throw new IllegalArgumentException("Entreprises can't have a parent structure !");
	}

	@Override
	public void setParent(AbstractStructure structure) {
		throw new IllegalArgumentException("Entreprises can't have a parent structure !");
	}

	@Override
	public void addChildStructure(AbstractStructure structure) {
		Objects.requireNonNull(structure);
		if(structure instanceof Department){
			Department department = (Department) structure;
			if(childrenStructures.putIfAbsent(department.getName(), department) != null)
				throw new IllegalArgumentException();
		}
		else
			throw new IllegalArgumentException();
	}

	@Override
	public void removeChildStructure(AbstractStructure structure) {
		Objects.requireNonNull(structure);
		if(structure instanceof Department){
			if(childrenStructures.remove(structure.getName()) == null)
				throw new IllegalArgumentException();
		}
		else
			throw new IllegalArgumentException();
	}

}
