package entreprise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import utilisateur.User;

import comportement.Ability;
import comportement.Role;

public class EntrepriseTest {

	/*
	 * Vérifie que les champs transmis via le constructeur
	 * sont correctes.
	 */
	@Test
	public void testEntrepriseConstructor() {
		User chief = new User("Tom", "1234", new Ability(Role.CompanyChief));
		Entreprise entreprise = new Entreprise("Entreprise 1", chief);
		assertEquals("Entreprise name isn't correct !", "Entreprise 1", entreprise.getName());
		assertNotNull("Chief is null !", entreprise.getChief());
	}
	
	/*
	 * Vérifie qu'une Entreprise ne peut pas avoir de chief null.
	 */	
	@Test(expected=NullPointerException.class)
	public void testEntrepriseSetChiefNull(){
		User chief = new User("Tom", "1234", new Ability(Role.CompanyChief));
		User newChief = null;
		Entreprise entreprise = new Entreprise("Entreprise 1", chief);
		entreprise.setChief(newChief);
	}
	
	/*
	 * Vérifie qu'une Entreprise accepte un membre non null.
	 */	
	@Test
	public void testEntrepriseAddMember(){
		User chief = new User("Tom", "1234", new Ability(Role.CompanyChief));
		User u = new User("Toto", "123456", new Ability(Role.User));
		Entreprise entreprise = new Entreprise("Entreprise 1", chief);
		entreprise.addMember(u);
		assertEquals("Members list size is not correct !", 1, entreprise.getMembers().size());
	}
	
	/*
	 * Vérifie qu'une Entreprise n'accepte pas un membre null.
	 */	
	@Test(expected=NullPointerException.class)
	public void testEntrepriseAddNullMember(){
		User chief = new User("Tom", "1234", new Ability(Role.CompanyChief));
		User u = null;
		Entreprise entreprise = new Entreprise("Entreprise 1", chief);
		entreprise.addMember(u);
	}

}
