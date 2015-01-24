package wpws;

import java.util.List;

public class WorkSpace {
	List<WorkPackage> wpList;

	public List<WorkPackage> getWpList() {
		return wpList;
	}

	public WSMaturity.State getWSMaturity() {
		throw new UnsupportedOperationException();
	}
}
