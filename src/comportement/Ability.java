package comportement;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import livre.Chapter;
import livre.SubChapter;
import livre.Volume;
import utilisateur.User;
import wpws.WorkPackage;
import wpws.WorkSpace;
import entreprise.Department;
import entreprise.Entreprise;
import entreprise.Service;

public abstract class Ability {

	private WorkSpace current;

	// Recupere la liste des workPackage qui nous a été affectée
	public List<WorkPackage> acquire() {
		List<WorkPackage> tmp = current.getParent().getWpList();
		List<WorkPackage> toReturn = new ArrayList<WorkPackage>();
		for (WorkPackage p : tmp) {
			if (p.getAssignedTo().equals(current))
				toReturn.add(p);
		}
		return toReturn;
	}

	// Recupere la liste des workPackage qu’on a affecté
	public List<WorkPackage> collect(){
		return new ArrayList<>(current.getTmpZone());
	}

	// Promo un workpackage dans le WS père
	public boolean promote(WorkPackage p) {
		return current.getParent().addWPTmpZone(p);
	}

	// Met a jour les WP ayant été accepté après un collect
	public boolean synchronize() {
		for (WorkPackage p : current.getTmpZone()) {
			if (!current.updateWP(p))
				return false;
		}
		return true;
	}

	// Creer un workSpace, renvoie null si echec
	public WorkSpace createWS() {
		if (current == null)
			current = new WorkSpace();
		return current;
	}

	public void setCurrentWS(WorkSpace current) {
		this.current = current;
	}

	public WorkSpace getCurrentWS() {
		return current;
	}

	/**
	 * CompanyChiefAbility Methods
	 */

	public Department createDepartment(String name) {
		throw new UnsupportedOperationException("Illegall Operation");
	}

	// Affecte un chef de departement à un departement
	public boolean setDepartmentChief(User u, Department d) {
		throw new UnsupportedOperationException("Illegall Operation");
	}

	// Creer un utilisateur avec son nom et mot de passe, renvoie null si échec
	public User createUser(String name, String pass) {
		throw new UnsupportedOperationException("Illegall Operation");
	}

	// Ajoute un wp à un département
	public boolean addWPToDepartment(WorkPackage WP, Department d) {
		throw new UnsupportedOperationException("Illegall Operation");
	}

	// Creer un chapitre, renvoie null si echec
	public Chapter createChapter(String name) {
		throw new UnsupportedOperationException("Illegall Operation");
	}

	// Attribut un chapitre à un WP
	public boolean addChapterToWP(Chapter c, WorkPackage WP) {
		throw new UnsupportedOperationException("Illegall Operation");
	}

	/**
	 * Contributor method
	 */

	public List<File> getFiles() {
		throw new UnsupportedOperationException("Illegall Operation");
	}

	/**
	 * DepartementChiefAbility
	 */

	// Creer un service avec son nom, renvoie null si echec
	public Service createService(String name) {
		throw new UnsupportedOperationException("Illegall Operation");
	}

	// Attribue un chef de service à un service donné
	public boolean setServiceChief(User u, Service s) {
		throw new UnsupportedOperationException("Illegall Operation");
	}

	// Creer un sous chapitre dans un chapitre, renvoie null si echec
	public SubChapter createSubChapter(Long id,String title,String name, Chapter c) {
		throw new UnsupportedOperationException("Illegall Operation");
	}

	// Attribut un sous chapitre à un WP
	public boolean addSubChapterToWP(SubChapter sc, WorkPackage w) {
		throw new UnsupportedOperationException("Illegall Operation");
	}

	/**
	 * HeadOfService ability
	 */

	// Cree un groupe
	public Void createGroup(String name) {
		throw new UnsupportedOperationException("Illegall Operation");
	}

	// Ajoute un membre au group
	public Void addUserToGroup(String name) {
		throw new UnsupportedOperationException("Illegall Operation");
	}

	// Attribue un jeton de promotion au groupe
	public Void givePromotionBeanToGroup() {
		throw new UnsupportedOperationException("Illegall Operation");
	}

	// retire le jeton de promotion au groupe
	public Void retreivePromotionBean() {
		throw new UnsupportedOperationException("Illegall Operation");
	}

	// assign un WP au groupe
	public Void assignWPToGroup(Long WPUI, String name) {
		throw new UnsupportedOperationException("Illegall Operation");
	}

	/**
	 * PatronAbility
	 */

	// Creer un volume en donnant son titre
	public Volume createVolume(String title) {
		throw new UnsupportedOperationException("Illegall Operation");
	}

	// Ajoute un volume à un WP
	public boolean addVolumeToWP(Volume v, WorkPackage p) {
		throw new UnsupportedOperationException("Illegall Operation");
	}

	// Creer une entrprise la renvoie renvoie null si echec
	public Entreprise createCompany(String name) {
		throw new UnsupportedOperationException("Illegall Operation");
	}

	// Attribut un workpackage à une entreprise
	public boolean addWPToCompany(WorkPackage wp, Entreprise c) {
		throw new UnsupportedOperationException("Illegall Operation");
	}

	// Attribut un chef à une entreprise
	public boolean nominateCompanyChief(User u, Entreprise c) {
		throw new UnsupportedOperationException("Illegall Operation");
	}

	// Creer un livre avec son nom
	public boolean createBook(String name) {
		throw new UnsupportedOperationException("Illegall Operation");
	}
}
