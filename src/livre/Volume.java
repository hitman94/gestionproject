package livre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/*
 * Classe qui repr�sente un Volume appartenant � un Book 
 */
public class Volume {

	private Long id;

	private String title;
	private String author;
	private Map<Long, ChapterInterface> chapters;
	private Book book;

	public Volume(Long id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.chapters = new HashMap<Long, ChapterInterface>();
		this.book = null;
	}

	public Volume(Long id, String title, String author, Book book) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.chapters = new HashMap<Long, ChapterInterface>();
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
	
	public List<ChapterInterface> getVolumes(){
		return new ArrayList<ChapterInterface>(chapters.values());
	}

	public ChapterInterface getChapter(Long id){
		return chapters.get(id);
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		Objects.requireNonNull(book);
		this.book = book;
	}

	public void addChapter(ChapterInterface chapterInterface){
		Objects.requireNonNull(chapterInterface);
		if(chapterInterface instanceof Chapter){
			Chapter chapter = (Chapter) chapterInterface;
			if(chapters.putIfAbsent(chapter.getId(), chapter) != null){
				throw new IllegalArgumentException();
			}	
		}
		else if(chapterInterface instanceof SubChapter){
			SubChapter subChapter = (SubChapter) chapterInterface;
			if(chapters.putIfAbsent(subChapter.getId(), subChapter) != null){
				throw new IllegalArgumentException();
			}
		}
		else
			throw new IllegalArgumentException();
	}

	public void removeChapter(ChapterInterface chapterInterface){
		Objects.requireNonNull(chapterInterface);
		if(chapterInterface instanceof Chapter){
			Chapter chapter = (Chapter) chapterInterface;
			if(chapters.remove(chapter.getId()) == null){
				throw new IllegalArgumentException();
			}	
		}
		else if(chapterInterface instanceof SubChapter){
			SubChapter subChapter = (SubChapter) chapterInterface;
			if(chapters.remove(subChapter.getId()) == null){
				throw new IllegalArgumentException();
			}
		}
		else
			throw new IllegalArgumentException();
	}

}
