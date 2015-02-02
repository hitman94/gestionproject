package entreprise;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import utilisateur.User;

public class Service extends AbstractStructure {
	
	private Department parentStructure;
	private Map<String, Group> childrenStructures;
	
	public Service(String name) {
		super(name);
		this.parentStructure = null;
		this.childrenStructures = new HashMap<String, Group>();
	}

	public Service(String name, User chief, Department parentStructure) {
		super(name, chief);
		this.parentStructure = Objects.requireNonNull(parentStructure);
		this.childrenStructures = new HashMap<String, Group>();
	}
	
	/*
	 * Renvoie le Group correspondant au nom donné en paramètre.
	 */
	public Group getGroup(String name) {
		return childrenStructures.get(name);
	}

	@Override
	public AbstractStructure getParent() {
		return parentStructure;
	}

	@Override
	public void setParent(AbstractStructure structure) {
		Objects.requireNonNull(structure);
		if(structure instanceof Department)
			this.parentStructure = (Department) structure;
		else
			throw new IllegalArgumentException();		
	}

	@Override
	public void addChildStructure(AbstractStructure structure) {
		Objects.requireNonNull(structure);
		if(structure instanceof Group){
			Group service = (Group) structure;
			if(childrenStructures.putIfAbsent(service.getName(), service) != null)
				throw new IllegalArgumentException();
		}
	}

	@Override
	public void removeChildStructure(AbstractStructure structure) {
		Objects.requireNonNull(structure);
		if(structure instanceof Group){
			Group service = (Group) structure;
			if(childrenStructures.remove(service.getName()) == null)
				throw new IllegalArgumentException();
		}
	}

}
