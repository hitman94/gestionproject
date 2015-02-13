package comportement;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import livre.Chapter;
import livre.Volume;
import utilisateur.User;
import wpws.WorkPackage;
import entreprise.Entreprise;

@Entity
public abstract class Ability {

	@Id
	@GeneratedValue
	private Long id;
	
	@Inject
	protected User currentUser;
	
	// Recupere la liste des workPackage qui nous a été affectée
	public List<WorkPackage> acquire() {
		List<WorkPackage> tmp = currentUser.getEntreprise().getWorkspace().getWpList();
		List<WorkPackage> toReturn = new ArrayList<WorkPackage>();
		for (WorkPackage p : tmp) {
			if (p.getAssignedTo().equals(currentUser.getEntreprise().getWorkspace()))
				toReturn.add(p);
		}
		return toReturn;
	}

	// Recupere la liste des workPackage qu’on a affecté
	public List<WorkPackage> collect(){
		return new ArrayList<>(currentUser.getEntreprise().getWorkspace().getTmpZone());
	}

	// Promo un workpackage dans le WS père
	public boolean promote(WorkPackage p) {
		return currentUser.getEntreprise().getWorkspace().getParent().addWPTmpZone(p);
	}

	// Met a jour les WP ayant été accepté après un collect
	public boolean synchronize() {
		for (WorkPackage p : currentUser.getEntreprise().getWorkspace().getTmpZone()) {
			if (!currentUser.getEntreprise().getWorkspace().updateWP(p))
				return false;
		}
		return true;
	}

	/**
	 * CompanyChiefAbility Methods
	 */



	// Creer un utilisateur avec son nom et mot de passe, renvoie null si échec
	public User createUser(String name, String pass) {
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
//	public boolean addWPToCompany(WorkPackage wp, Entreprise c) {
//		throw new UnsupportedOperationException("Illegall Operation");
//	}

	// Attribut un chef à une entreprise
	public boolean nominateCompanyChief(User u, Entreprise c) {
		throw new UnsupportedOperationException("Illegall Operation");
	}

	// Creer un livre avec son nom
	public boolean createBook(String name) {
		throw new UnsupportedOperationException("Illegall Operation");
	}
}
