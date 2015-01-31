package livre;

import static org.junit.Assert.*;

import org.junit.Test;

public class VolumeTest {

	@Test
	public void testVolumeConstructor(){
		Book b = new Book(new Long("1"), "Book 1", "Book Author");
		Volume v = new Volume(new Long("10"), "Volume 1", "Volume Author", b);
		assertEquals(new Long("10"), v.getId());
		assertEquals("Volume 1", v.getTitle());
		assertEquals("Volume Author", v.getAuthor());
		assertEquals(new Long("1"), v.getBook().getId());
	}
	
	@Test(expected = NullPointerException.class)
	public void testAddNullChapterInterface() {
		Volume v = new Volume(new Long("10"), "Volume 1", "Volume Author");
		ChapterInterface chapterInterface = null;
		v.addChapter(chapterInterface);
	}
	
	@Test
	public void testAddChapterInterface2Times() {
		Volume v = new Volume(new Long("10"), "Volume 1", "Volume Author");
		ChapterInterface chapterInterface = new Chapter(new Long("100"), "Chapter 1", "Chapter Author");
		ChapterInterface chapterInterface2 = new SubChapter(new Long("1000"), "SubChapter 1", "SubChapter Author");
		v.addChapter(chapterInterface);
		v.addChapter(chapterInterface2);
		assertNotEquals(((Chapter) chapterInterface).getTitle() + " ne peut être ajouté qu'1 fois.", true, v.addChapter(chapterInterface));
		assertNotEquals(((SubChapter) chapterInterface2).getTitle() + " ne peut être ajouté qu'1 fois.", true, v.addChapter(chapterInterface2));
	}
	
	@Test
	public void testRemoveChapterInterface2Times() {
		Volume v = new Volume(new Long("10"), "Volume 1", "Volume Author");
		ChapterInterface chapterInterface = new Chapter(new Long("100"), "Chapter 1", "Chapter Author");
		ChapterInterface chapterInterface2 = new SubChapter(new Long("1000"), "SubChapter 1", "SubChapter Author");
		v.addChapter(chapterInterface);
		v.addChapter(chapterInterface2);
		v.removeChapter(chapterInterface);
		v.removeChapter(chapterInterface2);
		assertNotEquals(((Chapter) chapterInterface).getTitle() + " ne peut être supprimé qu'1 fois.", true, v.removeChapter(chapterInterface));
		assertNotEquals(((SubChapter) chapterInterface2).getTitle() + " ne peut être supprimé qu'1 fois.", true, v.removeChapter(chapterInterface2));
	}

}
