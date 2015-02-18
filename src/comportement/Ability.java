package comportement;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ability {

	@Id
	@GeneratedValue
	private Long id;
	
	@Enumerated
	private Role role;
	
	public Ability() {
		// TODO Auto-generated constructor stub
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	
	public Role getRole() {
		return role;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	

}
