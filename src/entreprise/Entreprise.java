package entreprise;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import utilisateur.User;

public class Entreprise extends AbstractStructure {

	private List<Department> childrenStructures;

	public Entreprise(String name) {
		super(name);
		this.childrenStructures = new ArrayList<>();
	}

	public Entreprise(String name, User chief) {
		super(name, chief);
		this.childrenStructures = new ArrayList<>();
	}

	/*
	 * Retourne la liste des structures filles.
	 */
	public List<Department> getChildrenStructures() {
		return childrenStructures;
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
	public boolean addChildStructure(AbstractStructure structure) {
		Objects.requireNonNull(structure);
		if(structure instanceof Department){
			Department department = (Department) structure;
			if(!childrenStructures.contains(department))
				childrenStructures.add(department);
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean removeChildStructure(AbstractStructure structure) {
		Objects.requireNonNull(structure);
		if(structure instanceof Department){
			Department department = (Department) structure;
			if(childrenStructures.contains(department))
				childrenStructures.remove(department);
			return true;
		}
		else
			return false;
	}

}
