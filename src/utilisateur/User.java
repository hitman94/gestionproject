package utilisateur;

public class User {
	private String ID;
	private String prenom;
	private String nom;
	User(String ID, String prenom, String nom){
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

}
