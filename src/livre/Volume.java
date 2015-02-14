package livre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/*
 * Classe qui représente un Volume appartenant à un Book.
 */
@Entity
public class Volume {

	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	private String title;

	@OneToMany(mappedBy="volume")
	private Map<Long, Chapter> chapters;

	public Volume() {
		
	}

	public Volume(String title) {
		this.title = title;
		this.chapters = new HashMap<Long, Chapter>();
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
	
	public void setChapters(Map<Long, Chapter> chapters) {
		this.chapters = chapters;
	}
	
	public List<Chapter> getChapters() {
		return new ArrayList<Chapter>(chapters.values());
	}

	public Chapter getChapter(Long id) {
		return chapters.get(id);
	}

	public void addChapter(Chapter chapter) {
		Objects.requireNonNull(chapter);
		if (chapters.putIfAbsent(chapter.getId(), chapter) != null)
			throw new IllegalArgumentException();
	}

	public void removeChapter(Chapter chapter) {
		Objects.requireNonNull(chapter);
		if (chapters.remove(chapter.getId()) == null)
			throw new IllegalArgumentException();
	}

}
