package wpws;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


/**
 * Le workspace est compos�e d'un identifiant unique et d'une collection de workpackage qui le compose
 * @author emmanuel
 *
 */
@Entity
public class WorkSpace {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany(mappedBy="assignedTo")
	private Set<WorkPackage> wpList;	
	
	@OneToOne
	private WorkSpace parent;

	public WorkSpace() {
		
	}

	
	/**
	 * recupere l'identifiant unique du workspace
	 * @return
	 */
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setWpList(Set<WorkPackage> wpList) {
		this.wpList = wpList;
	}
	
	public Set<WorkPackage> getWpList() {
		return wpList;
	}
	/**
	 * recup�re la maturite du WS
	 * 
	 * @return
	 */
	
	

	public WSMaturity.State getWSMaturity() {

		// algorithme basic
		// la maturit� du ws depend de celle des wp$
		// si un wp est a un etat inferieur alors le ws est a cette etape
		// lews est done lorsque tous les wp sont done
		for (WorkPackage wp : wpList) {
			wpws.WPMaturity.State wpMaturity = wp.getStatus();
			if (wpMaturity.equals(WPMaturity.State.Start)) {
				return WSMaturity.State.Start;

			} else if (wpMaturity.equals(WPMaturity.State.InProgress)) {
				return WSMaturity.State.InProgress;
			}

		}
		return WSMaturity.State.Done;
	}
	
	public void setParent(WorkSpace parent) {
		this.parent = parent;
	}
	
	public WorkSpace getParent() {
		return parent;
	}
}
