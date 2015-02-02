package entreprise;

import java.util.ArrayList;
import java.util.List;

import utilisateur.User;

public class Service extends AbstractStructure {
	
	private Department parentStructure;
	private List<Group> childrenStructures;
	
	public Service(String name) {
		super(name);
		this.parentStructure = null;
		this.childrenStructures = new ArrayList<>();
	}

	public Service(String name, User chief, Department parentStructure) {
		super(name, chief);
		this.parentStructure = parentStructure;
		this.childrenStructures = new ArrayList<>();
	}
	
	/*
	 * Retourne la liste des structures filles.
	 */
	public List<Group> getChildrenStructures() {
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
