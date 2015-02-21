package livre;

import static org.junit.Assert.*;

import org.junit.Test;

import wpws.WorkPackage;

public class VolumeTest {

	@Test
	public void testVolumeConstructor(){
		WorkPackage workPackage = new WorkPackage();
		Volume v = new Volume("Volume 1", workPackage);
		assertEquals("Volume 1", v.getTitle());
		assertEquals(0, v.getChapters().size());
	}
	
	@Test(expected = NullPointerException.class)
	public void testAddNullChapter() {
		WorkPackage workPackage = new WorkPackage();
		Volume v = new Volume("Volume 1", workPackage);
		Chapter chapter = null;
		v.addChapter(chapter);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddChapter2Times() {
		WorkPackage wp = new WorkPackage();
		Volume v = new Volume("Volume 1", wp);
		Chapter chapter = new Chapter("Chapter 1", v, wp);
		v.addChapter(chapter);
		v.addChapter(chapter);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testRemoveChapter2Times() {
		WorkPackage wp = new WorkPackage();
		Volume v = new Volume("Volume 1", wp);
		Chapter chapter = new Chapter("Chapter 1", v, wp);
		v.addChapter(chapter);
		v.removeChapter(chapter);
		v.removeChapter(chapter);
	}

}
