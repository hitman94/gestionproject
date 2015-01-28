package livre;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Chapter implements ChapterInterface {

	private Long id;
	private String title;
	private String author;
	private List<Paragraph> chapterParagraphs;
	private List<SubChapter> subChapters;
	private Volume volume;


	public Chapter(Long id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.chapterParagraphs = new ArrayList<>();
		this.subChapters = new ArrayList<>(); 
		this.volume = null;
	}

	public Chapter(Long id, String title, String author, Volume volume) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.chapterParagraphs = new ArrayList<>();
		this.subChapters = new ArrayList<>();
		this.volume = volume;
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

	public List<SubChapter> getSubChapters(){
		return subChapters;
	}

	public void addSubChapter(SubChapter subChapter) {
		Objects.requireNonNull(subChapter);
		if(!subChapters.contains(subChapter))
			subChapters.add(subChapter);
	}

	public void removeSubChapter(SubChapter subChapter){
		Objects.requireNonNull(subChapter);
		if(subChapters.contains(subChapter))
			subChapters.remove(subChapter);
	}

	@Override
	public List<Paragraph> getParagraphs() {
		return chapterParagraphs;
	}

	@Override
	public void addParagraph(Paragraph paragraph) {
		Objects.requireNonNull(paragraph);
		if(!chapterParagraphs.contains(paragraph))
			chapterParagraphs.add(paragraph);
	}

	@Override
	public void removeParagraph(Paragraph paragraph){
		Objects.requireNonNull(paragraph);
		if(chapterParagraphs.contains(paragraph))
			chapterParagraphs.remove(paragraph);
	}

	@Override
	public Volume getVolume(){
		return volume;
	}

	@Override
	public void setVolume(Volume volume) {
		Objects.requireNonNull(volume);
		this.volume = volume;
	}

}
