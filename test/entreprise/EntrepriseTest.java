package entreprise;

import static org.junit.Assert.*;

import org.junit.Test;

import utilisateur.User;

public class EntrepriseTest {

	/*
	 * Vérifie que les champs transmis via le constructeur
	 * sont correctes.
	 */
	@Test
	public void testEntrepriseConstructor() {
		User chief = new User("ID", "Lastname", "Firstname");
		AbstractStructure structure = new Entreprise("Entreprise 1", chief);
		assertEquals("Entreprise name isn't correct !", "Entreprise 1", structure.getName());
		assertNotNull("Chief is null !", structure.getChief());
	}
	
	
	/*
	 * Vérifie qu'une Entreprise ne peut pas avoir de parent.
	 */	
	@Test(expected=IllegalArgumentException.class)
	public void testEntrepriseSetParent(){
		AbstractStructure structure = new Entreprise("Entreprise 1");
		AbstractStructure structure2 = new Entreprise("Entreprise 2");
		structure.setParent(structure2);
	}
	
	/*
	 * Vérifie qu'une Entreprise accepte un Department en tant que
	 * structure fille.
	 */	
	@Test
	public void testEntrepriseAddChild(){
		AbstractStructure structure = new Entreprise("Entreprise 1");
		AbstractStructure structure2 = new Department("Department 1");
		structure.addChildStructure(structure2);
		assertEquals("Children List size isn't correct !", 1, ((Entreprise) structure).getDepartments().size());
	}
	
	/*
	 * Vérifie qu'une Entreprise n'accepte que les Department en tant que
	 * structure fille.
	 */	
	@Test(expected=IllegalArgumentException.class)
	public void testEntrepriseAddWrongChild(){
		AbstractStructure structure = new Entreprise("Entreprise 1");
		AbstractStructure structure2 = new Group("Group 1");
		structure.addChildStructure(structure2);
	}

}
