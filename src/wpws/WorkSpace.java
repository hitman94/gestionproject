package wpws;

import java.util.List;

public class WorkSpace {
	List<WorkPackage> wpList;

	/**
	 * recupere la liste des WP du Workspace
	 * @return
	 */
	public List<WorkPackage> getWpList() {
		return wpList;
	}

	/**
	 * recupère la maturite du WS
	 * @return
	 */
	public WSMaturity.State getWSMaturity() {
		throw new UnsupportedOperationException();
	}
}
