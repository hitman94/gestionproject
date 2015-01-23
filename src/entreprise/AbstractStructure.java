package entreprise;

public interface AbstractStructure {

	/*
	 * R�cup�re le chef de l'AbstractStructure.
	 */
	public User getChief();
	
	/*
	 * Attribue le chef de l'AbstractStructure.
	 */
	public void setChief(User user);
	
	/*
	 * R�cup�re le parent de l'AbstractStructure.
	 */
	public AbstractStructure getParent();
	
	/*
	 * Attribue le parent de l'AbstractStructure.
	 */
	public void setParent();
	
}
