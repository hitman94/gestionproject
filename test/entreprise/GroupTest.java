package entreprise;

import static org.junit.Assert.*;

import org.junit.Test;

import comportement.Ability;

import utilisateur.User;
import utilisateur.UserFactory;

public class GroupTest {

	/*
	 * Vérifie que les champs transmis via le constructeur
	 * sont correctes.
	 */
	@Test
	public void testGroupConstructor() {
		User chief = UserFactory.createUser("Login", "Password", new Ability());
		AbstractStructure parent = new Service("Service 1");
		AbstractStructure structure = new Group("Group 1", chief, (Service) parent);
		assertEquals("Group name isn't correct !", "Group 1", structure.getName());
		assertNotNull("Chief is null !", structure.getChief());
		assertNotNull("Parent is null !", structure.getParent());
	}
	
	/*
	 * Vérifie que le parent est bien un Service.
	 */
	@Test
	public void testGroupSetParent(){
		AbstractStructure parent = new Service("Service 1");
		AbstractStructure structure = new Group("Group 1");
		structure.setParent(parent);
		assertEquals("Parent name isn't correct !", "Service 1", structure.getParent().getName());
	}
	
	/*
	 * Vérifie que le parent ne peut être qu'un Service.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testGroupSetWrongParent(){
		AbstractStructure parent = new Department("Department 1");
		AbstractStructure structure = new Group("Group 1");
		structure.setParent(parent);
	}
	
	/*
	 * Vérifie qu'une Group n'accepte pas de structure fille.
	 */	
	@Test(expected=IllegalArgumentException.class)
	public void testServiceAddChild(){
		AbstractStructure structure = new Group("Group 1");
		AbstractStructure structure2 = new Group("Group 2");
		structure.addChildStructure(structure2);
	}

}
