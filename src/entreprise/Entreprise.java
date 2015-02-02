package entreprise;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import utilisateur.User;

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

	@Override
	public AbstractStructure getParent() {
		return null;
	}

	@Override
	public void setParent(AbstractStructure structure) {
		return;
	}

	@Override
	public void addChildStructure(AbstractStructure structure) {
		Objects.requireNonNull(structure);
		if(structure instanceof Department){
			Department department = (Department) structure;
			if(childrenStructures.putIfAbsent(department.getName(), department) != null)
				throw new IllegalArgumentException();
		}
	}

	@Override
	public void removeChildStructure(AbstractStructure structure) {
		Objects.requireNonNull(structure);
		if(structure instanceof Department){
			Department department = (Department) structure;
			if(childrenStructures.remove(department.getName()) == null)
				throw new IllegalArgumentException();
		}
	}

}
