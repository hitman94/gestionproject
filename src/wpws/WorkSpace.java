package wpws;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import entreprise.Entreprise;

/**
 * Le workspace est compos�e d'un identifiant unique et d'une collection de
 * workpackage qui le compose
 * 
 * @author emmanuel
 *
 */
@Entity
public class WorkSpace {

	@Id
	@GeneratedValue
	private Long id;

	@OneToMany(mappedBy = "assignedTo", cascade = CascadeType.REMOVE)
	private Set<WorkPackage> wpList;

	@OneToOne(mappedBy = "workspace")
	private Entreprise ent;

	@OneToOne
	private WorkSpace parent;

	public WorkSpace() {

	}

	public WorkSpace(WorkSpace parent) {
		this.parent = parent;
		this.wpList = new HashSet<WorkPackage>();
	}

	/**
	 * recupere l'identifiant unique du workspace
	 * 
	 * @return
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setWpList(Set<WorkPackage> wpList) {
		this.wpList = new HashSet<WorkPackage>(wpList);
	}

	public List<WorkPackage> getWpList() {
		return new ArrayList<WorkPackage>(wpList);
	}

	public void setParent(WorkSpace parent) {
		this.parent = Objects.requireNonNull(parent);
	}

	public WorkSpace getParent() {
		return parent;
	}

	/**
	 * recup�re la maturite du WS
	 * 
	 * @return
	 */

	public WSMaturity getWSMaturity() {

		// algorithme basic
		// la maturit� du ws depend de celle des wp$
		// si un wp est a un etat inferieur alors le ws est a cette etape
		// lews est done lorsque tous les wp sont done
		for (WorkPackage wp : wpList) {
			wpws.WPMaturity wpMaturity = wp.getStatus();
			if (wpMaturity.equals(WPMaturity.Start)) {
				return WSMaturity.Start;

			} else if (wpMaturity.equals(WPMaturity.InProgress)) {
				return WSMaturity.InProgress;
			}

		}
		return WSMaturity.Done;
	}

	public boolean addWP(WorkPackage wp) {
		Objects.requireNonNull(wp);
		return wpList.add(wp);
	}

	public boolean removeWP(WorkPackage wp) {
		Objects.requireNonNull(wp);
		return wpList.remove(wp);
	}
}
