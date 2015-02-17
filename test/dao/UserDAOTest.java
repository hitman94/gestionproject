/**
 * 
 */
package dao;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import utilisateur.User;

/**
 * @author Florian
 * Cette classe contient les JUnit Test Case de la classe UserDAO
 */
public class UserDAOTest {
	@Inject
	private UserDAO dao;
	
	@Test
	public void addAndGetUserTest() {
		User u = new User("Dupont","salade", null);
		dao.persist(u);
		User u2 = dao.findById(u.getId());
		assertEquals("u et u2 sont different",u.getUserName(),u2.getUserName());
	}
	
	@Test
	public void deleteUser() {
		User u = new User("Dupont","salade", null);
		dao.persist(u);
		dao.remove(u);
		User u2 = dao.findById(u.getId());
		assertNull("u2 non null: delete rate",u2);
	}
	
	@Test
	public void updateUserTest() {
		User u = new User("Dupont","salade", null);
		dao.persist(u);
		u.setUserName("George");
		dao.update(u);
		User u2 = dao.findById(u.getId());
		assertNull("u2 null: update rat�",u2);
		assertEquals("Nom de u2 different de Bob, update rate","George", u2.getUserName());
	}
	
	@Test
	public void findAllTest() {
		User user1 =new User("joe","salade", null);
		User user2 = new User("Dupont","salade", null);
		User user3 =new User("bob","salade", null);
		User user4 = new User("Brenda","salade", null);
		dao.persist(user1);
		dao.persist(user2);
		dao.persist(user3);
		dao.persist(user4);
		assertEquals("4", dao.findAll().size());
	}
}
