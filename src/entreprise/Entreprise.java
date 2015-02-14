package entreprise;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
	private Set<User> members;
	
	@OneToOne
	private Volume volume;
	
	@OneToOne
	private WorkSpace workspace;
	
	public Entreprise() {
		
	}

	public Entreprise(String name, User chief, Volume volume) {
		this.name = name;
		this.chief = Objects.requireNonNull(chief);
		this.volume = Objects.requireNonNull(volume);
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
	
	public Volume getVolume() {
		return volume;
	}

	public void setVolume(Volume volume) {
		Objects.requireNonNull(volume);
		this.volume = volume;
	}

	public WorkSpace getWorkspace() {
		return workspace;
	}
	
	public void setWorkspace(WorkSpace workspace) {
		Objects.requireNonNull(workspace);
		this.workspace = workspace;
	}

}
