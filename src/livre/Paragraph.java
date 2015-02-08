package livre;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/*
 * Classe qui représente un Paragraph appartenant
 * à un Chapter ou un SubChapter.
 */
@Entity
public class Paragraph {
	
	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	private String title;
	@NotNull
	private String author;
	private ChapterInterface chapterInterface;
	
	public Paragraph(Long id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.chapterInterface = null;
	}
	
	public Paragraph(Long id, String title, String author, ChapterInterface chapterInterface) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.chapterInterface = Objects.requireNonNull(chapterInterface);
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

	public ChapterInterface getChapterInterface() {
		return chapterInterface;
	}

	public void setChapterInterface(ChapterInterface chapterInterface) {
		Objects.requireNonNull(chapterInterface);
		this.chapterInterface = chapterInterface;
	}

}
