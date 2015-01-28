package entreprise;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import utilisateur.User;

public class Entreprise implements AbstractStructure {

	private final int STRUCTURE_LEVEL = 1;

	private String name;
	private AbstractStructure parentStructure;
	private User chief;
	private List<AbstractStructure> childrenStructures;

	public Entreprise(String name) {
		this.name = name;
		this.parentStructure = null;
		this.chief = null;
		this.childrenStructures = new ArrayList<>();
	}

	public Entreprise(String name, AbstractStructure parentStructure, User chief) {
		this.name = name;
		this.parentStructure = parentStructure;
		this.chief = chief;
		this.childrenStructures = new ArrayList<>();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getStructureLevel() {
		return STRUCTURE_LEVEL;
	}

	@Override
	public User getChief() {
		return chief;
	}

	@Override
	public void setChief(User chief) {
		Objects.requireNonNull(chief);
		this.chief = chief;
	}

	@Override
	public AbstractStructure getParent() {
		return parentStructure;
	}

	@Override
	public void setParent(AbstractStructure structure) {
		Objects.requireNonNull(structure);
		if(this.getStructureLevel() < structure.getStructureLevel())
			this.parentStructure = structure;
		else
			throw new IllegalArgumentException("This structure can't be added as the parent of this entreprise !");
	}
	
	public List<AbstractStructure> getChildrenStructures() {
		return childrenStructures;
	}

	public void addChildStructure(AbstractStructure structure){
		Objects.requireNonNull(structure);
		if(this.getStructureLevel() > structure.getStructureLevel())
			childrenStructures.add(structure);
		else
			throw new IllegalArgumentException("This structure can't be added as a child of this entreprise !");
	}
	
	public void removeChildStructure(AbstractStructure structure){
		Objects.requireNonNull(structure);
		childrenStructures.remove(structure);
	}

}
