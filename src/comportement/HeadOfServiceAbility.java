package comportement;

import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.Current;

import utilisateur.User;
import entreprise.Group;

public class HeadOfServiceAbility extends Ability {
	List<Group> groups;
	Group groupWithPromotionBean;

	/**
	 * permet de creer un groupe
	 */

	public HeadOfServiceAbility() {
		groups = new ArrayList<Group>();
	}

	@Override
	public void createGroup(String name) {
		groups.add(new Group(name));
	}

	@Override
	public void addUserToGroup(User user, String name) {
		try {
			Group g = getGroupByname(name);
			g.addUser(user);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("There is no group name " + name);
		}
	}

	private Group getGroupByname(String name) {
		for (Group g : groups) {
			if (g.getName().equals(name)) {

				return g;
			}
		}
		throw new IllegalArgumentException("There is no group name " + name);
	}

	@Override
	public void givePromotionBeanToGroup(String name) {
		try {
			Group g = getGroupByname(name);
			groupWithPromotionBean = g;
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("There is no group name " + name);
		}
	}

	@Override
	public void retreivePromotionBean() {
		groupWithPromotionBean = null;
	}

	
}
