package livre;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import wpws.WorkPackage;

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

	@OneToMany(mappedBy="volume", fetch=FetchType.EAGER)
	@MapKey(name="numberInVolume")
	private Map<Long, Chapter> chapters;
	
	
	@ManyToOne
	@JoinColumn(name="WP_ID")
	private WorkPackage wp;

	public Volume() {
		
	}

	public Volume(String title, WorkPackage workPackage) {
		this.title = title;
		this.wp = Objects.requireNonNull(workPackage);
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
		this.chapters = new HashMap<Long, Chapter>(chapters);
	}
	
	public Map<Long, Chapter> getChapters() {
		return chapters;
	}

	public Chapter getChapter(Long numberInVolume) {
		return chapters.get(numberInVolume);
	}


	public WorkPackage getWp() {
		return wp;
	}
	
	public void setWp(WorkPackage assignedTo) {
		this.wp = assignedTo;
	}

}
