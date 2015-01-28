package livre;

import static org.junit.Assert.*;

import org.junit.Test;

public class BookTest {

	@Test
	public void addVolume2TimesTest() {
		Book b = new Book(new Long("1"), "Book 1", "Book Author1");
		Volume v = new Volume(new Long("10"), "Volume 1", "Volume Author");
		Volume v2 = new Volume(new Long("10"), "Volume 1", "Volume Author");
		b.addVolume(v);
		b.addVolume(v2);
		assertNotEquals("v et v2 sont identiques", v.getId(), v2.getId());
	}

}
