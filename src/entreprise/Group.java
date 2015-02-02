package entreprise;

import java.util.Objects;

import utilisateur.User;

public class Group extends AbstractStructure {
	
	private Service parentStructure;

	public Group(String name) {
		super(name);
		this.parentStructure = null;
	}

	public Group(String name, User chief, Service parentStructure) {
		super(name, chief);
		this.parentStructure = parentStructure;
	}

	@Override
	public AbstractStructure getParent() {
		return parentStructure;
	}

	@Override
	public void setParent(AbstractStructure structure) {
		Objects.requireNonNull(structure);
		if(structure instanceof Service)
			this.parentStructure = (Service) structure;
		
	}

	@Override
	public boolean addChildStructure(AbstractStructure structure) {
		return false;
	}

	@Override
	public boolean removeChildStructure(AbstractStructure structure) {
		return false;
	}

}
