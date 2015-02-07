package livre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.sun.istack.internal.NotNull;

/*
 * Classe qui représente un Book contenant des Volumes,
 * ChapterInterfaces, etc... 
 */
@Entity
public class Book {

	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	private String title;
	@NotNull
	private String author;
	private Map<Long, Volume> volumes;


	public Book(Long id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.volumes = new HashMap<Long, Volume>();
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
		return new ArrayList<Volume>(volumes.values());
	}

	public Volume getVolume(Long id){
		return volumes.get(id);
	}

	public void addVolume(Volume volume){
		Objects.requireNonNull(volume);
		if(volumes.putIfAbsent(volume.getId(), volume) != null){
			throw new IllegalArgumentException();
		}
	}

	public void removeVolume(Volume volume){
		Objects.requireNonNull(volume);
		if(volumes.remove(volume.getId()) == null){
			throw new IllegalArgumentException();
		}
	}

}
