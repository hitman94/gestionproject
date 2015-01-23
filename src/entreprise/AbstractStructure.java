package entreprise;

public interface AbstractStructure {

	/*
	 * Récupère le chef de l'AbstractStructure.
	 */
	public User getChief();
	
	/*
	 * Attribue le chef de l'AbstractStructure.
	 */
	public void setChief(User user);
	
	/*
	 * Récupère le parent de l'AbstractStructure.
	 */
	public AbstractStructure getParent();
	
	/*
	 * Attribue le parent de l'AbstractStructure.
	 */
	public void setParent();
	
}
