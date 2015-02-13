package entreprise;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import livre.Volume;
import utilisateur.User;

@Entity
public class Entreprise{

	@Id
	private String name;
	
	@NotNull
	private User chief;
	
	@OneToMany(mappedBy="entreprise")
	private List<User> members;
	
	@OneToOne
	private Volume volume;
	
	public Entreprise() {
		// TODO Auto-generated constructor stub
	}
	
	public Entreprise(String name) {
		this.name=name;
	}

	public Entreprise(String name, User chief) {
		this.name=name;
		this.chief=chief;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setChief(User chief) {
		this.chief = chief;
	}
	
	public User getChief() {
		return chief;
	}
	
	public List<User> getMembers() {
		return members;
	}
	
	public void addMembers(User u) {
		members.add(u);
	}

}
