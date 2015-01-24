package livre;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
 * Classe qui repr�sente un Volume appartenant � un Book 
 */
public class Volume {
	
	private Long id;
	
	private String title;
	private String author;
	private List<ChapterInterface> chapters;
	private Book book;
	
	public Volume(Long id, String title, String author, Book book) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.chapters = new ArrayList<ChapterInterface>();
		this.book = book;
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
	
	public List<ChapterInterface> getChapters(){
		return chapters;
	}
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void addChapter(ChapterInterface chapter){
		Objects.requireNonNull(chapter);
		chapters.add(chapter);
	}
	
	public void removeChapter(ChapterInterface chapter){
		Objects.requireNonNull(chapter);
		chapters.remove(chapter);
	}

}
