package entreprise;

import static org.junit.Assert.*;

import org.junit.Test;

import utilisateur.User;

public class DepartmentTest {

	/*
	 * Vérifie que les champs transmis via le constructeur
	 * sont correctes.
	 */
	@Test
	public void testDepartmentConstructor() {
		User chief = new User("ID", "Lastname", "Firstname");
		AbstractStructure parent = new Entreprise("Entreprise 1");
		AbstractStructure structure = new Department("Department 1", chief, (Entreprise) parent);
		assertEquals("Department name isn't correct !", "Department 1", structure.getName());
		assertNotNull("Chief is null !", structure.getChief());
		assertNotNull("Parent is null !", structure.getParent());
	}
	
	/*
	 * Vérifie que le parent est bien une Entreprise.
	 */
	@Test
	public void testDepartmentSetParent(){
		AbstractStructure parent = new Entreprise("Entreprise 1");
		AbstractStructure structure = new Department("Department 1");
		structure.setParent(parent);
		assertEquals("Parent name isn't correct !", "Entreprise 1", structure.getParent().getName());
	}
	
	/*
	 * Vérifie que le parent ne peut être qu'une Entreprise.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testDepartmentSetWrongParent(){
		AbstractStructure parent = new Group("Group 1");
		AbstractStructure structure = new Department("Department 1");
		structure.setParent(parent);
	}
	
	/*
	 * Vérifie qu'un Department accepte un Service en tant que
	 * structure fille.
	 */	
	@Test
	public void testDepartmentAddChild(){
		AbstractStructure structure = new Department("Department 1");
		AbstractStructure child = new Service("Service 1");
		structure.addChildStructure(child);
		assertEquals("Children List size isn't correct !", 1, ((Department) structure).getServices().size());
	}
	
	/*
	 * Vérifie qu'une Department n'accepte que les Service en tant que
	 * structure fille.
	 */	
	@Test(expected=IllegalArgumentException.class)
	public void testDepartmentAddWrongChild(){
		AbstractStructure structure = new Department("Department 1");
		AbstractStructure structure2 = new Group("Group 1");
		structure.addChildStructure(structure2);
	}

}
