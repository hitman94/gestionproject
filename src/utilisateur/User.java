package utilisateur;

public class User {
	private Long id;
	private String name ;
	private String firstName;
	User(Long id, String name, String firstName){
		this.id = id;
		this.name = name;
		this.firstName = firstName;
	}

	public Long getId()
	{
		return id;
	}

	public void setId( Long id )
	{
		this.id = id;
	}

	public String getFirstName ()
	{
		return firstName;
	}
	public void setFirstName (String firstName)
	{
		this.firstName = firstName;
	}
	public String getName()
	{
		return name ;
	}

	public void setName (String name)
	{
		this.name = name;
	}

}
