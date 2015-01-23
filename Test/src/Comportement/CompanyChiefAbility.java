package Comportement;

public class CompanyChiefAbility {
	//Creer un departement avec son nom, renvoie null si echec
	public Department createDepartment(String name){}
	//Affecte un chef de departement à un departement
	public boolean setDepartmentChief(User u, Department d){}
	//Creer un utilisateur avec son nom et mot de passe, renvoie null si échec
	public User createUser(String name,String pass){}
	//Ajoute un wp à un département
	public boolean addWPToDepartment(Workpackage WP, Department d){}
	//Creer un chapitre, renvoie null si echec
	public Chapter createChapter(String name){}
	//Attribut un chapitre à un WP
	public boolean addChapterToWP(Chapter c, Workpackage WP){}

}
