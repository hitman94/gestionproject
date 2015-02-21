package livre;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import wpws.WorkPackage;

public class ChapterTest {

	@Test
	public void testChapterConstructor(){
		WorkPackage wp = new WorkPackage();
		Volume v = new Volume("Volume 1", wp);
		Chapter chapter = new Chapter("Chapter 1", v, wp);
		assertEquals("Chapter 1", chapter.getTitle());
		assertEquals("Volume 1", chapter.getVolume().getTitle());
	}
	
}
