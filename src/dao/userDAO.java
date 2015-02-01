package dao;

import java.util.List;

import wpws.WorkPackage;
import entreprise.AbstractStructure;


public class userDAO {
	//retourne le User correspondant à l’id
	public User getUserById(Guid ID){}
	//suprimme le User correspondant
	public boolean deleteUser(User u){}
	//sauvegarde le User sur la base de donnée
	public void saveUser(User wp){}
	//met à jour les données du User sur la base de donnée
	public void updateUser(User wp){}
	//retourne une liste de tout les User
	public List<WorkPackage> findAll(){}
}
