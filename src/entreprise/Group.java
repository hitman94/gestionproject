package entreprise;

import java.util.Objects;

import utilisateur.User;

public class Group extends AbstractStructure {
	
	private Service parentStructure;

	public Group(String name) {
		super(name);
		this.parentStructure = null;
	}
	
	public Group(String name, User chief) {
		super(name, chief);
		this.parentStructure = null;
	}

	public Group(String name, User chief, Service parentStructure) {
		super(name, chief);
		this.parentStructure = Objects.requireNonNull(parentStructure);
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
		else
			throw new IllegalArgumentException();
	}

	@Override
	public void addChildStructure(AbstractStructure structure) {
		throw new IllegalArgumentException("Groups can't have children structures !");
	}

	@Override
	public void removeChildStructure(AbstractStructure structure) {
		throw new IllegalArgumentException("Groups can't have children structures !");
	}

}
