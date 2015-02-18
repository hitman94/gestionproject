package livre;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import wpws.WorkPackage;

public class ChapterTest {

	@Test
	public void testChapterConstructor(){
		WorkPackage workPackage = new WorkPackage();
		Volume v = new Volume("Volume 1", workPackage);
		Chapter chapter = new Chapter("Chapter 1", v);
		assertEquals("Chapter 1", chapter.getTitle());
		assertEquals("Volume 1", chapter.getVolume().getTitle());
	}
	
}
