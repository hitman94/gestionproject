package livre;

import static org.junit.Assert.*;

import org.junit.Test;

public class SubChapterTest {

	@Test
	public void testSubChapterConstructor(){
		Volume v = new Volume(new Long("10"), "Volume 1", "Volume Author");
		ChapterInterface chapter = new Chapter(new Long("100"), "Chapter 1", "Chapter Author");
		ChapterInterface subChapter = new SubChapter(new Long("1000"), "SubChapter 1", "SubChapter Author", (Chapter) chapter, v);
		assertEquals(new Long("1000"), ((SubChapter) subChapter).getId());
		assertEquals("SubChapter 1", ((SubChapter) subChapter).getTitle());
		assertEquals("SubChapter Author", ((SubChapter) subChapter).getAuthor());
		assertEquals(new Long("10"), subChapter.getVolume().getId());
		assertEquals(new Long("100"), ((SubChapter) subChapter).getChapter().getId());
	}

	@Test(expected = NullPointerException.class)
	public void testAddNullParagraph() {
		ChapterInterface subChapter = new SubChapter(new Long("1000"), "SubChapter 1", "SubChapter Author");
		Paragraph paragraph = null;
		subChapter.addParagraph(paragraph);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddParagraph2Times() {
		ChapterInterface subChapter = new SubChapter(new Long("1000"), "SubChapter 1", "SubChapter Author");
		Paragraph paragraph = new Paragraph(new Long("10000"), "Paragraph 1", "Paragraph Author");
		subChapter.addParagraph(paragraph);
		subChapter.addParagraph(paragraph);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRemoveParagraph2Times() {
		ChapterInterface subChapter = new SubChapter(new Long("1000"), "SubChapter 1", "SubChapter Author");
		Paragraph paragraph = new Paragraph(new Long("10000"), "Paragraph 1", "Paragraph Author");
		subChapter.addParagraph(paragraph);
		subChapter.removeParagraph(paragraph);
		subChapter.removeParagraph(paragraph);
	}

}
