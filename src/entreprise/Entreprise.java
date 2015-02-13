package entreprise;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import livre.Volume;
import utilisateur.User;
import wpws.WorkSpace;

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
	
	@OneToOne
	private WorkSpace workspace;
	
	public Entreprise() {
	}
	
	public Entreprise(String name) {
		this.name=name;
		this.workspace = new WorkSpace();
	}

	public Entreprise(String name, User chief) {
		this.name=name;
		this.chief=chief;
		this.workspace = new WorkSpace();
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
	
	public WorkSpace getWorkspace() {
		return workspace;
	}
	
	public void setWorkspace(WorkSpace workspace) {
		this.workspace = workspace;
	}

}
