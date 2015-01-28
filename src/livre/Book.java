package livre;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
 * Classe qui représente un Book contenant des Volumes,
 * ChapterInterfaces, etc... 
 */
public class Book {

	private Long id;
	private String title;
	private String author;
	private List<Volume> volumes;


	public Book(Long id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.volumes = new ArrayList<Volume>();
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

	public List<Volume> getVolumes(){
		return volumes;
	}

	public void addVolume(Volume volume){
		Objects.requireNonNull(volume);
		if(!volumes.contains(volume))
			volumes.add(volume);
	}

	public boolean removeVolume(Volume volume){
		Objects.requireNonNull(volume);
		if(volumes.contains(volume)){
			volumes.remove(volume);
			return true;
		}
		else
			return false;
		
	}


}
