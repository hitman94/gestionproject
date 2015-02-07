package entreprise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import utilisateur.User;

@Entity
public class Service extends AbstractStructure {
	
	private Department parentStructure;
	private Map<String, Group> childrenStructures;
	
	public Service(String name) {
		super(name);
		this.parentStructure = null;
		this.childrenStructures = new HashMap<String, Group>();
	}

	public Service(String name, User chief) {
		super(name, chief);
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
	
	/*
	 * Renvoie la liste de Group.
	 */
	public List<Group> getGroups() {
		return new ArrayList<Group>(childrenStructures.values());
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
			Group group = (Group) structure;
			if(childrenStructures.putIfAbsent(group.getName(), group) != null)
				throw new IllegalArgumentException();
		}
		else
			throw new IllegalArgumentException();
	}

	@Override
	public void removeChildStructure(AbstractStructure structure) {
		Objects.requireNonNull(structure);
		if(structure instanceof Group){
			if(childrenStructures.remove(structure.getName()) == null)
				throw new IllegalArgumentException();
		}
		else
			throw new IllegalArgumentException();
	}

}
