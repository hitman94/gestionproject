package wpws;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


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
	private Set<WorkPackage> wpList;	
	private Set<WorkPackage> tmpList;
	private WorkSpace parent;

	public WorkSpace() {
		wpList = new HashSet<WorkPackage>();
		tmpList=new HashSet<>();
	}

	/**
	 * recupere la liste des WP du Workspace
	 * 
	 * @return
	 */
	
	public boolean updateWP(WorkPackage p) {
		wpList.remove(p);
		return wpList.add(p);
	}
	
	public List<WorkPackage> getWpList() {
		return new ArrayList<WorkPackage>(wpList);
	}

	public boolean addWP(WorkPackage wp) {
		return wpList.add(wp);
	}

	public boolean removeWP(WorkPackage wp) {
		return wpList.remove(wp);
	}
	
	public boolean addWPTmpZone(WorkPackage wp) {
		return tmpList.add(wp);
	}
	public boolean removeWPTmpZone(WorkPackage wp) {
		return tmpList.remove(wp);
	}
	
	public Set<WorkPackage> getTmpZone() {
		return tmpList;
	}
	
	/**
	 * recupere l'identifiant unique du workspace
	 * @return
	 */
	public Long getId() {
		return id;
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
