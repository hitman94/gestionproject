package utilisateur;

import static org.junit.Assert.*;

import org.junit.Test;

import comportement.Ability;
import comportement.CompanyChiefAbility;

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

	}
	@Test
	public void testNullPassWord(){

	}
	@Test 
	public void testUserBelongToEntreprise(){
		//test si le user appartient à l'entreprise
	}
	@Test
	public void testUserBelongToGroupe(){
		//entreprise.getmember()

	}
	@Test
	public void testUserIsChef(){

	}
















}
