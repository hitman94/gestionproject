package entreprise;

import static org.junit.Assert.*;

import org.junit.Test;

import comportement.HeadOfServiceAbility;

import utilisateur.User;
import utilisateur.UserFactory;

public class ServiceTest {

	/*
	 * Vérifie que les champs transmis via le constructeur
	 * sont correctes.
	 */
	@Test
	public void testServiceConstructor() {
		User chief = UserFactory.createUser("Login", "Password", new HeadOfServiceAbility());
		AbstractStructure parent = new Department("Department 1");
		AbstractStructure structure = new Service("Service 1", chief, (Department) parent);
		assertEquals("Service name isn't correct !", "Service 1", structure.getName());
		assertNotNull("Chief is null !", structure.getChief());
		assertNotNull("Parent is null !", structure.getParent());
	}
	
	/*
	 * Vérifie que le parent est bien un Department.
	 */
	@Test
	public void testServiceSetParent(){
		AbstractStructure parent = new Department("Department 1");
		AbstractStructure structure = new Service("Service 1");
		structure.setParent(parent);
		assertEquals("Parent name isn't correct !", "Department 1", structure.getParent().getName());
	}
	
	/*
	 * Vérifie que le parent ne peut être qu'un Department.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testServiceSetWrongParent(){
		AbstractStructure parent = new Group("Group 1");
		AbstractStructure structure = new Service("Service 1");
		structure.setParent(parent);
	}
	
	/*
	 * Vérifie qu'un Service accepte un Group en tant que
	 * structure fille.
	 */	
	@Test
	public void testServiceAddChild(){
		AbstractStructure structure = new Service("Service 1");
		AbstractStructure child = new Group("Group 1");
		structure.addChildStructure(child);
		assertEquals("Children List size isn't correct !", 1, ((Service) structure).getGroups().size());
	}
	
	/*
	 * Vérifie qu'une Service n'accepte que les Group en tant que
	 * structure fille.
	 */	
	@Test(expected=IllegalArgumentException.class)
	public void testServiceAddWrongChild(){
		AbstractStructure structure = new Service("Service 1");
		AbstractStructure structure2 = new Department("Department 1");
		structure.addChildStructure(structure2);
	}

}
