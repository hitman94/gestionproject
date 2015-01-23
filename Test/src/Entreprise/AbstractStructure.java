package Entreprise;

public interface AbstractStructure {
	//Récupère le chef de l’AbstractStructure
	public User getChief();
	//Récupère l’AbstractStructure parente
	public AbstractStructure getParent();
	//Attribue l’AbstractStructure parente
	public void setParent(AbstractStructure abstractStructure);
}
