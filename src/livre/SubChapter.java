package livre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/*
 * Classe qui représente un SubChapter héritant d'une ChapterInterface
 * et appartenant à un Volume et à un Chapter.
 */
@Entity
public class SubChapter implements ChapterInterface {

	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	private String title;
	@NotNull
	private String author;
	private Map<Long, Paragraph> subChapterParagraphs;
	private Chapter chapter;
	private Volume volume;

	public SubChapter(Long id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.subChapterParagraphs = new HashMap<Long, Paragraph>();
		this.chapter = null;
		this.volume = null;
	}

	public SubChapter(Long id, String title, String author, Chapter chapter) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.subChapterParagraphs = new HashMap<Long, Paragraph>();
		this.chapter = Objects.requireNonNull(chapter);
		this.volume = null;
	}
	
	public SubChapter(Long id, String title, String author, Chapter chapter, Volume volume) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.subChapterParagraphs = new HashMap<Long, Paragraph>();
		this.chapter = Objects.requireNonNull(chapter);
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

	public Chapter getChapter() {
		return chapter;
	}

	public void setChapter(Chapter chapter) {
		Objects.requireNonNull(chapter);
		this.chapter = chapter;
	}
	
	public Paragraph getParagraph(Long id){
		return subChapterParagraphs.get(id);
	}

	@Override
	public List<Paragraph> getParagraphs() {
		return new ArrayList<Paragraph>(subChapterParagraphs.values());
	}

	@Override
	public void addParagraph(Paragraph paragraph) {
		Objects.requireNonNull(paragraph);
		if(subChapterParagraphs.putIfAbsent(paragraph.getId(), paragraph) != null)
			throw new IllegalArgumentException();
	}

	@Override
	public void removeParagraph(Paragraph paragraph) {
		Objects.requireNonNull(paragraph);
		if(subChapterParagraphs.remove(paragraph.getId()) == null)
			throw new IllegalArgumentException();
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
