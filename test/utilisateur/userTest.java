package utilisateur;

import static org.junit.Assert.*;

import org.junit.Test;

public class userTest {

	@Test
	public void testUserConstructor() {
		User u = new User(new Long(1),"Fatou","Ba");
		assertEquals(new Long(1), u.getId());
		assertEquals("Fatou", u.getName());
		assertEquals("Ba", u.getFirstName());
	}

}
