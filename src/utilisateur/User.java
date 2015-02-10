package utilisateur;


import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import comportement.Ability;



@Entity( name=User.USER)//Entity_name
@Access(AccessType.PROPERTY) //modif by getters/setters
public class User {
	public static final String USER="User";
	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@Size(min = 2, message="User name name too short")
	private String userName ;
	@NotNull
	@Size(min = 4, message="passWord must contain more than 4 caractere")
	private Long passWord;
	@OneToMany
	private List<Ability> ability;
	User(){
	}
	User(String userName, Long passWord,List<Ability> ability){
		this.userName = userName;
		this.passWord = passWord;
		this.ability = ability;
	}

	public Long getId()
	{
		return id;
	}

	public void setId( Long id )
	{
		this.id = id;
	}

	public String getUserName ()
	{
		return userName;
	}
	public void setUserName (String userName)
	{
		this.userName = userName;
	}

	public Long getPassWord()
	{
		return passWord;
	}

	public void setPassWord( Long passWord )
	{
		this.passWord = passWord;
	}

	public List<Ability> getAbility()
	{
		return ability;
	}

	public void setAbility( List<Ability> ability )
	{
		this.ability = ability;
	}
}
