package utilisateur;
import static org.junit.Assert.*;
import javax.validation.constraints.AssertTrue;
import org.junit.Test;
import comportement.Ability;
import entreprise.Entreprise;

public class userTest {

	@Test
	public void testUserConstructor() {
		Ability a = Ability.CompanyChief;
		//Utilisateurs, Chef d'entreprise et Patron du Livre
		User u =new  User("Fatou","12344",Ability.CompanyChief) ;
		assertEquals("Fatou", u.getUserName());
		assertEquals("12344", u.getPassWord());
		//assertTrue(u.getAbility().equals(a));
		assertEquals(Ability.CompanyChief,u.getAbility());
	}
	@Test(expected = NullPointerException.class)
	public void testNullAbility(){	
		Ability a = null;
		User u =new  User("Fatou","12344",a) ;
		//if(u.getAbility()==null)
			//throw new IllegalArgumentException();
	}
	@Test 
	public void testNullUserName(){
		Ability a = null;
		User u =new  User("","12344",a) ;
		if(u.getUserName()==null)
			throw new IllegalArgumentException();
	}
	@Test
	public void testNullPassWord(){
		// test pour verifier que le mot de passe n'est pas null
		Ability a = null;
		User u =new  User("Fatou","",a) ;
		if(u.getPassWord()== null)
			throw new IllegalArgumentException();

	}

	/*	@Test 
       public void createUserTest(){
		// Test pour verifier que les utilisateurs n'ont pas les m�mes nom
		//pour la cr�ation d'un utilisateur
		CompanyChiefAbility a = null;
		User u =new  User("Fatou","12344",a);
		u.
		if(u.equals(u))
			throw new IllegalArgumentException();	
	}*/

	@Test 
	public void testUserBelongToEntreprise(){
		//test si le user appartient à l'entreprise
		Entreprise e = new Entreprise();
		User u =new  User("Fatou","12344", Ability.User) ;
		e.addMember(u);
		assertEquals(u, e.getMembers());
	}
	@Test
	public void testUserBelongToGroupe(){
		//test pour verifier s'il fait partie de la liste des utilisateurs
		Entreprise e = null;
		User u =new  User("Fatou","12344", Ability.User);	
	}

	@Test
	public void testUserIsChef(){
		// test si l'utilisateur est un chef
		Entreprise e = null;
		User u =new  User("Fatou","12344", Ability.CompanyChief);
		e.addMember(u);
		assertEquals(u, e.getChief());	
	}

}
