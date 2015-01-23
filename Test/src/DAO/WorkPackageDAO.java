package DAO;

import java.awt.List;

import WorkPackage_WorkSpace.WorkPackage;

public class WorkPackageDAO {
	//retourne le WorkPackage correspondant à l’id
	public User getWorkPackageById(Guid ID){}
	//suprimme le WorkPackage correspondant
	public boolean deleteWorkPackage(WorkPackage u){}
	//sauvegarde le WorkPackage sur la base de donnée
	public void saveWorkPackage(WorkPackage wp){}
	//met à jour les données de WorkPackage sur la base de donnée
	public void updateWorkPackage(WorkPackage wp){}
	//retourne une liste de toutes les WorkPackage
	public List<WorkPackage> findAll(){}
}
