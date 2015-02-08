package utilisateur;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

public class UserFactoryTest {

	@Test
	public void testCreateUser(){
		User u = new User(new Long(1),"Fatou","Ba");
		//assertEquals(, actual);
	}
	@Test(expected = NullPointerException.class)
	public void testAddNullUser(){
		UserFactory uf = new UserFactory();
		uf.createUser(null, null, null);
	}
	@Test
	public void testUserExist(){
		UserFactory uf = new UserFactory();
		User u1= new User(new Long(1),"Fatou","Ba");
		uf.addUser("Ba", "Fatou", new Long(1));
		uf.addUser("Ba", "Fatou", new Long(1));
	} 

	@Test
	public void testdeleteUser(){
		User u= new User(new Long(1),"Fatou","Ba");
	}
}
