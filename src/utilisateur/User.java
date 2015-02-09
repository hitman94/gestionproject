package utilisateur;



@Entity( name=USER)//Entity_name
@Access(AcessType.Property) //modif by getters/setters
public class User {
	public static final String USER="User";
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;


	@Size(min = 2, message="Last name too short")
	private String name ;
	@Size(min = 2, message="First name too short")
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
