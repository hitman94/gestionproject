package comportement;

import java.util.ArrayList;
import java.util.List;

import livre.Chapter;
import livre.SubChapter;
import utilisateur.User;
import wpws.WorkPackage;
import entreprise.Service;

public class DepartmentChiefAbility extends Ability {
	private List<Service> services = new ArrayList<Service>();

	/**
	 * cree le service avec son nom en parametre
	 */
	@Override
	public Service createService(String name) {
		Service service = new Service(name);
		services.add(service);
		return service;
	}

	/**
	 * attribu un chef de service
	 */
	@Override
	public boolean setServiceChief(User u, Service s) {
		s.setChief(u);
		return true;
	}

	/**
	 * ajoute le sous chapitre au workpackage
	 */
	@Override
	public boolean addSubChapterToWP(SubChapter sc, WorkPackage w) {
		w.addSubChapter(sc);
		return true;
	}

	/**
	 * crre un sous chapitre du chapitre donne en parametre
	 */
	@Override
	public SubChapter createSubChapter(Long id, String title, String name,
			Chapter c) {
		return new SubChapter(id, title, name, c);
	}
}
