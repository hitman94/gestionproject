package livre;

import static org.junit.Assert.*;

import org.junit.Test;

public class BookTest {

	@Test
	public void addVolume2TimesTest() {
		Book b = new Book(new Long("1"), "Book 1", "Book Author");
		Volume v = new Volume(new Long("10"), "Volume 1", "Volume Author");
		b.addVolume(v);
		b.addVolume(v);
		assertEquals(v.getId() + " ne doit pas être ajouté 2 fois.", b.getVolumes().size(), 1);
	}
	
	public void removeVolume2TimesTest() {
		Book b = new Book(new Long("1"), "Book 1", "Book Author");
		Volume v = new Volume(new Long("10"), "Volume 1", "Volume Author");
		b.addVolume(v);
		b.removeVolume(v);
		assertNotEquals(v.getId() + " ne peut être supprimé qu'1 fois.", b.removeVolume(v), true);
	}

}
