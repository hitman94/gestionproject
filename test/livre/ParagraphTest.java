package livre;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParagraphTest {

	@Test
	public void testParagraphConstructor(){
		ChapterInterface chapter = new Chapter(new Long("100"), "Chapter 1", "Chapter Author");
		Paragraph paragraph = new Paragraph(new Long("10000"), "Paragraph 1", "Paragraph Author", chapter);
		assertEquals(new Long("10000"), paragraph.getId());
		assertEquals("Paragraph 1", paragraph.getTitle());
		assertEquals("Paragraph Author", paragraph.getAuthor());
		assertEquals(new Long("100"), ((Chapter) paragraph.getChapterInterface()).getId());
	}

}
