package entreprise;

import java.util.ArrayList;
import java.util.List;

import utilisateur.User;

public class Department extends AbstractStructure {
	
	private Entreprise parentStructure;
	private List<Service> childrenStructures;
	
	public Department(String name) {
		super(name);
		this.parentStructure = null;
		this.childrenStructures = new ArrayList<>();
	}

	public Department(String name, User chief, Entreprise parentStructure) {
		super(name, chief);
		this.parentStructure = parentStructure;
		this.childrenStructures = new ArrayList<>();
	}
	
	/*
	 * Retourne la liste des structures filles.
	 */
	public List<Service> getChildrenStructures() {
		return childrenStructures;
	}

	@Override
	public AbstractStructure getParent() {
		return parentStructure;
	}

	@Override
	public void setParent(AbstractStructure structure) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addChildStructure(AbstractStructure structure) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeChildStructure(AbstractStructure structure) {
		// TODO Auto-generated method stub
		return false;
	}

}
