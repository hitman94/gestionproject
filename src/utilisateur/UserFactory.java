package utilisateur;


public class UserFactory {
	private String ID;
	private String prenom;
	private String nom;
	//private String adresse;
	
	public UserFactory (String ID, String prenom, String nom)
	{
		this.ID = ID;
		this.prenom = prenom;
		this.nom = nom;
	}
	
	public String getID()
	{
		return ID;
	}
	
	public void setId( String ID)
	{
		this.ID = ID;
	}
	
	public String getNom ()
	{
		return nom;
	}
	public void SetNom (String nom)
	{
		this.nom = nom;
	}
	public String getPrenom()
	{
		return prenom ;
	}
	
	public void setPrenom (String prenom)
	{
		this.prenom = prenom;
	}
		
	//Permet de créer un utilisateur et de lui assigner des droits grâce à une Ability.
	public void createUser(String  nom,String prenom, String ID){
		UserFactory u = new UserFactory(ID, prenom, prenom);
		
		
	}
	//Permet de supprimer  un utilisateur mais le donner de son compte doit toujours exister
	public void deleteUser(String ID){
		
	}
	
	//Permet de supprimer  un utilisateur mais le donner de son compte doit toujours exister
	public void addUser(String  nom, String prenom, String ID){
		
	}
	
	
	
}
