package comportement;

import entreprise.Entreprise;
import livre.Volume;
import utilisateur.User;
import wpws.WorkPackage;


@Entity
public class PatronAbility extends Ability {

	
	public PatronAbility() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * create volume with given title
	 */
	@Override
	public Volume createVolume(String title) {
		return new Volume(title);
	}

	/**
	 * add the given volume to WP
	 */
	@Override
	public boolean addVolumeToWP(Volume v, WorkPackage p) {
	
		 p.addVolume(v);
		 return true;
	}


	/**
	 * create a company with the given name
	 */
	@Override
	public Entreprise createCompany(String name) {
		return new Entreprise(name);
	}

	/**
	 * add WP TO Company
	 */
	// @Override
	// public boolean addWPToCompany(WorkPackage wp, Entreprise c) {
	//
	// }

	/**
	 * set chief to user
	 */
	@Override
	public boolean nominateCompanyChief(User u, Entreprise c) {
		
		 c.setChief(u);
		 return true;
	}

	/**
	 * create a book
	 */
	@Override
	public boolean createBook(String name) {
		
		return new Book(name);
	}
}
