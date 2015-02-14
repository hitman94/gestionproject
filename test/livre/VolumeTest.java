package livre;

import static org.junit.Assert.*;

import org.junit.Test;

public class VolumeTest {

	@Test
	public void testVolumeConstructor(){
		Volume v = new Volume("Volume 1");
		assertEquals("Volume 1", v.getTitle());
		assertEquals(0, v.getChapters().size());
	}
	
	@Test(expected = NullPointerException.class)
	public void testAddNullChapterInterface() {
		Volume v = new Volume("Volume 1");
		Chapter chapter = null;
		v.addChapter(chapter);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddChapterInterface2Times() {
		Volume v = new Volume("Volume 1");
		Chapter chapter = new Chapter("Chapter 1", v);
		v.addChapter(chapter);
		v.addChapter(chapter);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testRemoveChapterInterface2Times() {
		Volume v = new Volume("Volume 1");
		Chapter chapter = new Chapter("Chapter 1", v);
		v.addChapter(chapter);
		v.removeChapter(chapter);
		v.removeChapter(chapter);
	}

}
