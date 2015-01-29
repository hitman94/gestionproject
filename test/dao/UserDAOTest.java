/**
 * 
 */
package dao;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Florian
 * Cette classe contient les JUnit Test Case de la classe UserDAO
 */
public class UserDAOTest {

	@Test
	public void addAndGetUserTest() {
		User u = new User("Dupont");
		saveUser(u);
		User u2 = getUserById("Dupont");
		assertEquals("u et u2 sont different",u.getNom(), u2.getNom());
	}
	
	@Test
	public void deleteUser() {
		User u = new User("Dupont");
		saveUser(u);
		deleteUser(u);
		User u2 = getUserById("Dupont");
		assertNull("u2 non null: delete rat�"u2);
	}
	
	@Test
	public void updateUserTest() {
		User u = new User("Dupont");
		saveUser(u);
		u.setNom("Bob");
		updateUser(u);
		User u2 = getUserById("Bob");
		assertNull("u2 null: update rat�"u2);
		assertEquals("Nom de u2 different de Bob, update rat�","Bob" u2.getNom());
	}
	
	@Test
	public void findAllTest() {
		User user1 = new User("Averell");
		User user2 = new User("Joe");
		User user3 = new User("Wiliam");
		User user4 = new User("Jack");
		saveUser(user1);
		saveUser(user2);
		saveUser(user3);
		saveUser(user4);
		assertEquals("4", findAll().size());
	}
}
