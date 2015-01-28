package entreprise;

import utilisateur.User;

public interface AbstractStructure {
	
	/*
	 * R�cup�re le nom de l'AbstractStructure.
	 */
	public String getName();

	/*
	 * Attribue le nom de l'AbstractStructure.
	 */
	public void setName(String name);

	/*
	 * R�cup�re le chef de l'AbstractStructure.
	 */
	public User getChief();
	
	/*
	 * Attribue le chef de l'AbstractStructure.
	 */
	public void setChief(User chief);
	
	/*
	 * R�cup�re le parent de l'AbstractStructure.
	 */
	public AbstractStructure getParent();
	
	/*
	 * Attribue le parent de l'AbstractStructure.
	 */
	public void setParent(AbstractStructure structure);
	
	/*
	 * R�cup�re le niveau de l'AbstractStructure:
	 * 1 -- Entreprise
	 * 2 -- Department
	 * 3 -- Service
	 * 4 -- Group
	 */
	public int getStructureLevel();
	
}
