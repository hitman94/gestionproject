package comportement;

import java.util.Objects;

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

	}
	
	public Ability(Role role) {
		this.role = Objects.requireNonNull(role);
	}
	
	public void setRole(Role role) {
		Objects.requireNonNull(role);
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
