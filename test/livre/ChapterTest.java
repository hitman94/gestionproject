package livre;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChapterTest {

	@Test
	public void testChapterConstructor(){
		Volume v = new Volume("Volume 1");
		Chapter chapter = new Chapter("Chapter 1", v);
		assertEquals("Chapter 1", chapter.getTitle());
		assertEquals("Volume 1", chapter.getVolume().getTitle());
	}

}
