package livre;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChapterTest {

	@Test
	public void testChapterConstructor(){
		Volume v = new Volume(new Long("10"), "Volume 1", "Volume Author");
		ChapterInterface chapter = new Chapter(new Long("100"), "Chapter 1", "Chapter Author", v);
		assertEquals(new Long("100"), ((Chapter) chapter).getId());
		assertEquals("Chapter 1", ((Chapter) chapter).getTitle());
		assertEquals("Chapter Author", ((Chapter) chapter).getAuthor());
		assertEquals(new Long("10"), chapter.getVolume().getId());
	}
	
	@Test(expected = NullPointerException.class)
	public void testAddNullSubChapter() {
		ChapterInterface chapter = new Chapter(new Long("100"), "Chapter 1", "Chapter Author");
		SubChapter subChapter = null;
		((Chapter) chapter).addSubChapter(subChapter);
	}
	
	@Test(expected = NullPointerException.class)
	public void testAddNullParagraph() {
		ChapterInterface chapterInterface = new Chapter(new Long("100"), "Chapter 1", "Chapter Author");
		Paragraph paragraph = null;
		((Chapter) chapterInterface).addParagraph(paragraph);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddSubChapter2Times() {
		ChapterInterface chapter = new Chapter(new Long("100"), "Chapter 1", "Chapter Author");
		ChapterInterface subChapter = new SubChapter(new Long("1000"), "SubChapter 1", "SubChapter Author");
		((Chapter) chapter).addSubChapter((SubChapter) subChapter);
		((Chapter) chapter).addSubChapter((SubChapter) subChapter);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddParagraph2Times() {
		ChapterInterface chapter = new Chapter(new Long("100"), "Chapter 1", "Chapter Author");
		Paragraph paragraph = new Paragraph(new Long("10000"), "Paragraph 1", "Paragraph Author");
		chapter.addParagraph(paragraph);		
		chapter.addParagraph(paragraph);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testRemoveSubChapter2Times() {
		ChapterInterface chapter = new Chapter(new Long("100"), "Chapter 1", "Chapter Author");
		ChapterInterface subChapter = new SubChapter(new Long("1000"), "SubChapter 1", "SubChapter Author");
		((Chapter) chapter).addSubChapter((SubChapter) subChapter);
		((Chapter) chapter).removeSubChapter((SubChapter) subChapter);
		((Chapter) chapter).removeSubChapter((SubChapter) subChapter);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testRemoveParagraph2Times() {
		ChapterInterface chapter = new Chapter(new Long("100"), "Chapter 1", "Chapter Author");
		Paragraph paragraph = new Paragraph(new Long("10000"), "Paragraph 1", "Paragraph Author");
		chapter.addParagraph(paragraph);
		chapter.removeParagraph(paragraph);
		chapter.removeParagraph(paragraph);
	}

}
