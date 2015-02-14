package comportement;

import javax.persistence.Entity;

import livre.Volume;
import utilisateur.User;
import wpws.WorkPackage;
import entreprise.Entreprise;


@Entity
public class PatronAbility extends Ability {


	public PatronAbility() {

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
		return p.addVolume(v);
	}

	/**
	 * create a company with the given name
	 */
	@Override
	public Entreprise createCompany(String name, User chief, Volume volume) {
		return new Entreprise(name, chief, volume);
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

}
