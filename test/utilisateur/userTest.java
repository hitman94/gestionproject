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
	@Test(expected = IllegalArgumentException.class)
	public void testNullAbility(){	
		CompanyChiefAbility a = null;
		assertFalse(throwException());
	}
	private boolean throwException(){
		throw new IllegalArgumentException();
	}
	

}
