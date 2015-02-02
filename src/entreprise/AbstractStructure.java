package entreprise;

import java.util.Objects;

import utilisateur.User;

public abstract class AbstractStructure {

	private String name;
	private User chief;
	

	public AbstractStructure(String name) {
		this.name = name;
		this.chief = null;
	}

	public AbstractStructure(String name, User chief) {
		this.name = name;
		this.chief = chief;
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
	 * 
	 */
	public abstract boolean addChildStructure(AbstractStructure structure);

	/*
	 * Supprime une structure fille à l'AbstractStructure.
	 */
	public abstract boolean removeChildStructure(AbstractStructure structure);

}
