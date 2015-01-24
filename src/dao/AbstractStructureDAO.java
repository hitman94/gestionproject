package dao;

import entreprise.AbstractStructure;



public class AbstractStructureDAO {
	//retourne l’AbstractStructure correspondant à l’id
	public AbstractStructure getAbstractStructureDAOById(Guid ID){}
	//suprimme l’AbstractStructure correspondant
	public boolean deleteAbstractStructure(AbstractStructure u){}
	//sauvegarde le AbstractStructure sur la base de donnée
	public void saveAbstractStructure(AbstractStructure u){}
	//met à jour les données de AbstractStructure sur la base de donnée
	public void updateAbstractStructure(AbstractStructure u){}
}
