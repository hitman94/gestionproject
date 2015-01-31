package wpws;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Le workspace est composée d'un identifiant unique et d'une collection de workpackage qui le compose
 * @author emmanuel
 *
 */
public class WorkSpace {
	private final UUID id;
	private final Set<WorkPackage> wpList;	

	public WorkSpace() {
		id = UUID.randomUUID();
		wpList = new HashSet<WorkPackage>();
	}

	/**
	 * recupere la liste des WP du Workspace
	 * 
	 * @return
	 */
	public List<WorkPackage> getWpList() {
		return new ArrayList<WorkPackage>(wpList);
	}

	public void addWP(WorkPackage wp) {
		wpList.add(wp);
	}

	public boolean removeWP(WorkPackage wp) {
		return wpList.remove(wp);
	}
	
	/**
	 * recupere l'identifiant unique du workspace
	 * @return
	 */
	public UUID getId() {
		return id;
	}
	/**
	 * recupère la maturite du WS
	 * 
	 * @return
	 */

	public WSMaturity.State getWSMaturity() {

		// algorithme basic
		// la maturité du ws depend de celle des wp$
		// si un wp est a un etat inferieur alors le ws est a cette etape
		// lews est done lorsque tous les wp sont done
		for (WorkPackage wp : wpList) {
			wpws.WPMaturity.State wpMaturity = wp.getWPMaturity();
			if (wpMaturity.equals(WPMaturity.State.Start)) {
				return WSMaturity.State.Start;

			} else if (wpMaturity.equals(WPMaturity.State.InProgress)) {
				return WSMaturity.State.InProgress;
			}

		}
		return WSMaturity.State.Done;
	}
}
