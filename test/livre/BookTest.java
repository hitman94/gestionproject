package livre;

import static org.junit.Assert.*;

import org.junit.Test;

public class BookTest {

	@Test
	public void testBookConstructor(){
		Book b = new Book(new Long("1"), "Book 1", "Book Author");
		assertEquals(new Long("1"), b.getId());
		assertEquals("Book 1", b.getTitle());
		assertEquals("Book Author", b.getAuthor());
	}
	
	@Test(expected = NullPointerException.class)
	public void testAddNullVolume() {
		Book b = new Book(new Long("1"), "Book 1", "Book Author");
		Volume v = null;
		b.addVolume(v);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddVolume2Times() {
		Book b = new Book(new Long("1"), "Book 1", "Book Author");
		Volume v = new Volume(new Long("10"), "Volume 1", "Volume Author");
		b.addVolume(v);
		b.addVolume(v);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testRemoveVolume2Times() {
		Book b = new Book(new Long("1"), "Book 1", "Book Author");
		Volume v = new Volume(new Long("10"), "Volume 1", "Volume Author");
		b.addVolume(v);
		b.removeVolume(v);
		b.removeVolume(v);
	}

}
