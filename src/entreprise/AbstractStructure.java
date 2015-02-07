package entreprise;

import java.util.Objects;

import utilisateur.User;
import wpws.WorkSpace;

@Entity
public abstract class AbstractStructure {

	@NotNull
	private String name;
	private User chief;
	private WorkSpace workSpace;

	public AbstractStructure(String name) {
		this.name = name;
		this.chief = null;
	}

	public AbstractStructure(String name, User chief) {
		this.name = name;
		this.chief = Objects.requireNonNull(chief);
	}
	
	public WorkSpace getWorkSpace() {
		return workSpace;
	}
	
	public void setWorkSpace(WorkSpace workSpace) {
		this.workSpace = workSpace;
	}

	/*
	 * Récupère le nom de l'AbstractStructure.
	 */
	public String getName() {
		return name;
	}

	/*
	 * Attribue le nom de l'AbstractStructure.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * Récupère le chef de l'AbstractStructure.
	 */
	public User getChief() {
		return chief;
	}

	/*
	 * Attribue le chef de l'AbstractStructure.
	 */
	public void setChief(User chief) {
		Objects.requireNonNull(chief);
		this.chief = chief;
	}

	/*
	 * Récupère le parent de l'AbstractStructure.
	 */
	public abstract AbstractStructure getParent();

	/*
	 * Attribue le parent de l'AbstractStructure.
	 */
	public abstract void setParent(AbstractStructure structure);


	/*
	 * Ajoute une structure fille à l'AbstractStructure. 
	 */
	public abstract void addChildStructure(AbstractStructure structure);

	/*
	 * Supprime une structure fille de l'AbstractStructure.
	 */
	public abstract void removeChildStructure(AbstractStructure structure);

}
