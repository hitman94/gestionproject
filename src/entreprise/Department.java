package entreprise;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import utilisateur.User;

public class Department extends AbstractStructure {
	
	private Entreprise parentStructure;
	private Map<String, Service> childrenStructures;
	
	public Department(String name) {
		super(name);
		this.parentStructure = null;
		this.childrenStructures = new HashMap<String, Service>();
	}

	public Department(String name, User chief, Entreprise parentStructure) {
		super(name, chief);
		this.parentStructure = Objects.requireNonNull(parentStructure);
		this.childrenStructures = new HashMap<String, Service>();
	}
	
	/*
	 * Renvoie le Service correspondant au nom donné en paramètre.
	 */
	public Service getService(String name) {
		return childrenStructures.get(name);
	}

	@Override
	public AbstractStructure getParent() {
		return parentStructure;
	}

	@Override
	public void setParent(AbstractStructure structure) {
		Objects.requireNonNull(structure);
		if(structure instanceof Entreprise){
			this.parentStructure = (Entreprise) structure;
		}
		else
			throw new IllegalArgumentException();
	}

	@Override
	public void addChildStructure(AbstractStructure structure) {
		Objects.requireNonNull(structure);
		if(structure instanceof Service){
			Service service = (Service) structure;
			if(childrenStructures.putIfAbsent(service.getName(), service) != null)
				throw new IllegalArgumentException();
		}
	}

	@Override
	public void removeChildStructure(AbstractStructure structure) {
		Objects.requireNonNull(structure);
		if(structure instanceof Service){
			Service service = (Service) structure;
			if(childrenStructures.remove(service.getName()) == null)
				throw new IllegalArgumentException();
		}
	}

}
