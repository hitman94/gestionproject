package livre;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SubChapter implements ChapterInterface {
	
	private Long id;
	private String title;
	private String author;
	private List<Paragraph> subChapterParagraphs;
	private Volume volume;
	private Chapter chapter;
	
	public SubChapter(Long id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.subChapterParagraphs = new ArrayList<>();
		this.volume = null;
		this.chapter = null;
	}
	
	public SubChapter(Long id, String title, String author, Volume volume, Chapter chapter) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.subChapterParagraphs = new ArrayList<>();
		this.volume = volume;
		this.chapter = chapter;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Chapter getChapter() {
		return chapter;
	}

	public void setChapter(Chapter chapter) {
		Objects.requireNonNull(chapter);
		this.chapter = chapter;
	}

	@Override
	public List<Paragraph> getParagraphs() {
		return subChapterParagraphs;
	}

	@Override
	public void addParagraph(Paragraph paragraph) {
		Objects.requireNonNull(paragraph);
		subChapterParagraphs.add(paragraph);
	}

	@Override
	public void removeParagraph(Paragraph paragraph) {
		Objects.requireNonNull(paragraph);
		subChapterParagraphs.remove(paragraph);		
	}

	@Override
	public Volume getVolume() {
		return volume;
	}

	@Override
	public void setVolume(Volume volume) {
		Objects.requireNonNull(volume);
		this.volume = volume;
	}

}
