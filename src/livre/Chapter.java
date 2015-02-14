package livre;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/*
 * Classe qui représente un Chapter héritant d'une ChapterInterface
 * et appartenant à un Volume.
 */
@Entity
public class Chapter {

	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	private String title;

	private String content;
	
	@ManyToOne
	@NotNull
	private Volume volume;

	public Chapter() {
	
	}

	public Chapter(String title, Volume volume) {
		this.title = title;
		this.content = new String();
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Volume getVolume(){
		return volume;
	}

	public void setVolume(Volume volume) {
		Objects.requireNonNull(volume);
		this.volume = volume;
	}

}
