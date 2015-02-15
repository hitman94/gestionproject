package utilisateur;

import static org.junit.Assert.*;
import org.junit.Test;

import comportement.Ability;
import comportement.CompanyChiefAbility;
import entreprise.Entreprise;

public class userTest {

	@Test
	public void testUserConstructor() {
		CompanyChiefAbility a = new CompanyChiefAbility();
		//Utilisateurs, Chef d'entreprise et Patron du Livre
		User u =new  User("Fatou","12344",a) ;
		assertEquals("Fatou", u.getUserName());
		assertEquals("12344", u.getPassWord());
		assertEquals("CompanyChiefAbility", a.getClass().getSimpleName());
	}
	@Test(expected = NullPointerException.class)
	public void testNullAbility(){	
		CompanyChiefAbility a = null;
		User u =new  User("Fatou","12344",a) ;
		if(u.getAbility()==null)
			throw new IllegalArgumentException();
	}
	@Test 
	public void testNullUserName(){
		CompanyChiefAbility a = null;
		User u =new  User("","12344",a) ;
		if(u.getUserName()==null)
			throw new IllegalArgumentException();
	}
	@Test
	public void testNullPassWord(){
		// test pour verifier que le mot de passe n'est pas null
		CompanyChiefAbility a = null;
		User u =new  User("Fatou","",a) ;
		if(u.getPassWord()== null)
			throw new IllegalArgumentException();

	}
	
	@Test 
	/*public void createUserTest(){
		// Test pour verifier que les utilisateurs n'ont pas les mêmes nom
		//pour la création d'un utilisateur
		CompanyChiefAbility a = null;
		User u =new  User("Fatou","12344",a);
		u.
		if(u.equals(u))
			throw new IllegalArgumentException();	
	}*/
	@Test 
	public void testUserBelongToEntreprise(){
		//test si le user appartient Ã  l'entreprise
		Entreprise e = null;
		CompanyChiefAbility a = new CompanyChiefAbility();
		User u =new  User("Fatou","12344", a) ;
		e.addMember(u);
		assertEquals(u, e.getMembers());
	}
	@Test
	public void testUserBelongToGroupe(){
		//test pour verifier s'il fait partie de la liste des utilisateurs
		Entreprise e = null;
		CompanyChiefAbility a = new CompanyChiefAbility();
		User u =new  User("Fatou","12344", a);	
	}
	
	@Test
	public void testUserIsChef(){
		// test si l'utilisateur est un chef
		Entreprise e = null;
		CompanyChiefAbility a = new CompanyChiefAbility();
		User u =new  User("Fatou","12344", a) ;
		e.addMember(u);
		assertEquals(u, e.getChief());	
	}
	
}
