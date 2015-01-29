package livre;

import static org.junit.Assert.*;

import org.junit.Test;

public class BookTest {

	@Test
	public void bookConstructorTest(){
		Book b = new Book(new Long("1"), "Book 1", "Book Author");
		assertEquals(new Long("1"), b.getId());
		assertEquals("Book 1", b.getTitle());
		assertEquals("Book Author", b.getAuthor());
	}
	
	@Test(expected = NullPointerException.class)
	public void addNullVolumeTest() {
		Book b = new Book(new Long("1"), "Book 1", "Book Author");
		Volume v = null;
		b.addVolume(v);
	}
	
	@Test
	public void addVolume2TimesTest() {
		Book b = new Book(new Long("1"), "Book 1", "Book Author");
		Volume v = new Volume(new Long("10"), "Volume 1", "Volume Author");
		b.addVolume(v);
		assertNotEquals(v.getTitle() + " ne peut être ajouté qu'1 fois.", true, b.addVolume(v));
	}
	
	public void removeVolume2TimesTest() {
		Book b = new Book(new Long("1"), "Book 1", "Book Author");
		Volume v = new Volume(new Long("10"), "Volume 1", "Volume Author");
		b.addVolume(v);
		b.removeVolume(v);
		assertNotEquals(v.getTitle() + " ne peut être supprimé qu'1 fois.", true, b.removeVolume(v));
	}

}
