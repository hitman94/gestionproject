package livre;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import wpws.WorkPackage;

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
	
	@ManyToOne
	@NotNull
	@JoinColumn(name="VOL_ID")
	private Volume volume;
	
	@ManyToOne
	@JoinColumn(name="WP_ID")
	@NotNull
	private WorkPackage wp;
	
	@NotNull
	private Long takenDate=-1L;

	public Chapter() {
	
	}

	public Chapter(String title, Volume volume,WorkPackage p) {
		this.title = title;
		this.volume = Objects.requireNonNull(volume);
		this.wp=Objects.requireNonNull(p);
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

	public Volume getVolume(){
		return volume;
	}

	public void setVolume(Volume volume) {
		Objects.requireNonNull(volume);
		this.volume = volume;
	}
	
	public Long getTakenDate() {
		return takenDate;
	}
	
	public void setTakenDate(Long takenDate) {
		this.takenDate = takenDate;
	}
	
	public void setWp(WorkPackage wp) {
		this.wp = wp;
	}
	
	public WorkPackage getWp() {
		return wp;
	}

}
