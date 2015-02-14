package comportement;

import livre.Chapter;
import livre.Volume;
import utilisateur.User;
import wpws.WorkPackage;


public class CompanyChiefAbility extends Ability {

	/*
	 * Creer un utilisateur avec son nom, son mot de passe et son ability.
	 * Renvoie null si échec.
	 */
	@Override
	public User createUser(String name, String pass, Ability ability) {
		return new User(name, pass, ability);
	}

	/*
	 * Creer un chapitre avec son titre et le Volume auquel il appartient.
	 * Renvoie null si échec.
	 */
	@Override
	public Chapter createChapter(String title, Volume volume) {
		return new Chapter(title, volume);
	}

	/*
	 * Attribut un chapitre à un WP(non-Javadoc)
	 */
	@Override
	public boolean addChapterToWP(Chapter c, WorkPackage wp) {
		return wp.addChapter(c);
	}

}
