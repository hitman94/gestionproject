package entreprise;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import utilisateur.User;
import wpws.WorkSpace;

import comportement.Ability;

@Entity
public class Entreprise{

	@Id
	private String name;
	
	@NotNull
	@OneToOne
	private User chief;
	
	@OneToMany(mappedBy="entreprise")
	private Set<User> members;
	
	@OneToOne
	private WorkSpace workspace;
	
	public Entreprise() {
		
	}

	public Entreprise(String name, User chief) {
		this.name = name;
		this.chief = Objects.requireNonNull(chief);
		this.workspace = new WorkSpace();
		this.members = new HashSet<User>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setChief(User chief) {
		Objects.requireNonNull(chief);
		chief.setAbility(Ability.CompanyChief);
		this.chief = chief;
	}
	
	public User getChief() {
		return chief;
	}
	
	public Set<User> getMembers() {
		return members;
	}
	
	public void addMember(User u) {
		Objects.requireNonNull(u);
		members.add(u);
	}
	

	public WorkSpace getWorkspace() {
		return workspace;
	}
	
	public void setWorkspace(WorkSpace workspace) {
		Objects.requireNonNull(workspace);
		this.workspace = workspace;
	}

}
