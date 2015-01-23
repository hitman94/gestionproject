package DAO;

public class UserDAO {
	//retourne le User correspondant à l’id
	public User getUserById(Guid ID){}
	//supprime l’utilisateur correspondant
	public boolean deleteUser(User u){}
	//sauvegarde le User sur la base de donnée
	public void saveUser(User u){}
	//met à jours les données de User sur la base de donnée
	public void updateUser(User u){}
	//retourne une liste de tous les utilisateurs
	public List<User> findAll(){}
}
