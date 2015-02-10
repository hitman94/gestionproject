package utilisateur;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import comportement.Ability;

public class userTest {

	@Test
	public void testUserConstructor() {
		Ability a ;//How to get user or specify user abilities??
		User u = new User("Fatou",new Long(12344),null);
	
		assertEquals("Fatou", u.getUserName());
		assertEquals(new Long(12344), u.getPassWord());
		assertEquals(null, u.getAbility());
	}

}
