package livre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/*
 * Classe qui représente un Chapter héritant d'une ChapterInterface
 * et appartenant à un Volume.
 */
@Entity
public class Chapter implements ChapterInterface {

	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	private String title;
	@NotNull
	private String author;
	private Map<Long, Paragraph> chapterParagraphs;
	private Map<Long, SubChapter> subChapters;
	private Volume volume;


	public Chapter(Long id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.chapterParagraphs = new HashMap<Long, Paragraph>();
		this.subChapters = new HashMap<Long, SubChapter>();
		this.volume = null;
	}

	public Chapter(Long id, String title, String author, Volume volume) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.chapterParagraphs = new HashMap<Long, Paragraph>();
		this.subChapters = new HashMap<Long, SubChapter>();
		this.volume = Objects.requireNonNull(volume);
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

	public SubChapter getSubChapter(Long id){
		return subChapters.get(id);
	}

	public List<SubChapter> getSubChapters(){
		return new ArrayList<SubChapter>(subChapters.values());
	}

	public void addSubChapter(SubChapter subChapter) {
		Objects.requireNonNull(subChapter);
		if(subChapters.putIfAbsent(subChapter.getId(), subChapter) != null)
			throw new IllegalArgumentException();
	}

	public void removeSubChapter(SubChapter subChapter){
		Objects.requireNonNull(subChapter);
		if(subChapters.remove(subChapter.getId()) == null)
			throw new IllegalArgumentException();
	}

	@Override
	public List<Paragraph> getParagraphs() {
		return new ArrayList<Paragraph>(chapterParagraphs.values());
	}

	@Override
	public void addParagraph(Paragraph paragraph) {
		Objects.requireNonNull(paragraph);
		if(chapterParagraphs.putIfAbsent(paragraph.getId(), paragraph) != null)
			throw new IllegalArgumentException();
	}

	@Override
	public void removeParagraph(Paragraph paragraph){
		Objects.requireNonNull(paragraph);
		if(chapterParagraphs.remove(paragraph.getId()) == null)
			throw new IllegalArgumentException();
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
