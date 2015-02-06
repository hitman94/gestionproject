package comportement;



import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.Entity;

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
	
	//Recupere la liste des workPackage qui nous a été affectée
	public List<WorkPackage> acquire(){
		List<WorkPackage> tmp = current.getParent().getWpList();
		List<WorkPackage> toReturn = new ArrayList<WorkPackage>();
		for(WorkPackage p : tmp) {
			if(p.getAssignedTo().equals(current))
				toReturn.add(p);
		}
		return toReturn;
	}
	
	//Recupere la liste des workPackage qu’on a affecté
	public List<WorkPackage> collect(){
		return new ArrayList<>(current.getTmpZone());
	}
	//Promo un workpackage dans le WS père
	public boolean promote(WorkPackage p){
		return current.getParent().addWPTmpZone(p);
	}
	//Met a jour les WP ayant été accepté après un collect
	public boolean synchronize(){
		for(WorkPackage p : current.getTmpZone()) {
			if(!current.updateWP(p))
				return false;
		}
		return true;
	}
	//Creer un workSpace, renvoie null si echec
	public WorkSpace createWS(){
		if(current==null)
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
	
	
	public abstract Department createDepartment(String name);
	//Affecte un chef de departement à un departement
	public abstract boolean setDepartmentChief(User u, Department d);
	//Creer un utilisateur avec son nom et mot de passe, renvoie null si échec
	public abstract User createUser(String name,String pass);
	//Ajoute un wp à un département
	public abstract boolean addWPToDepartment(WorkPackage WP, Department d);
	//Creer un chapitre, renvoie null si echec
	public abstract Chapter createChapter(String name);
	//Attribut un chapitre à un WP
	public abstract boolean addChapterToWP(Chapter c, WorkPackage WP);
	
	/**
	 * Contributor method
	 */
	
	public abstract List<File> getFiles();
	
	/**
	 * DepartementChiefAbility
	 */
	
	//Creer un service avec son nom, renvoie null si echec
		public abstract Service createService(String name);
		//Attribue un chef de service à un service donné
		public abstract boolean setServiceChief(User u, Service s);
		//Creer un sous chapitre dans un chapitre, renvoie null si echec
		public abstract SubChapter createSubChapter(String name, Chapter c);
	//Attribut un sous chapitre à un WP
		public abstract boolean addSubChapterToWP(SubChapter sc, WorkPackage w);
		
		/**
		 * HeadOfService ability
		 */
	
		//Cree un groupe
		public abstract Void createGroup(String name);
		//Ajoute un membre au group
		public abstract Void addUserToGroup(String name);
		//Attribue un jeton de promotion au groupe
		public abstract Void givePromotionBeanToGroup();
		//retire le jeton de promotion au groupe
		public abstract Void retreivePromotionBean();
		//assign un  WP au groupe
		public abstract Void assignWPToGroup(Long WPUI,String name);
		
		/**
		 * PatronAbility	
		 */
		
		// Creer un volume en donnant son titre
		public abstract Volume createVolume(String title);

		// Ajoute un volume à un WP
		public abstract boolean addVolumeToWP(Volume v, WorkPackage p);

		// Creer une entrprise la renvoie renvoie null si echec
		public abstract Entreprise createCompany(String name);

		// Attribut un workpackage à une entreprise
		public abstract boolean addWPToCompany(WorkPackage wp, Entreprise c);

		// Attribut un chef à une entreprise
		public abstract boolean nominateCompanyChief(User u, Entreprise c);

		// Creer un livre avec son nom
		public abstract boolean createBook(String name);
}
