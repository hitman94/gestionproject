package wpws;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import livre.Chapter;
import livre.Volume;

@Entity
public class WorkPackage {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private WPMaturity.State status;
	
	@ManyToOne
	@JoinColumn(name="WS_ID")
	private WorkSpace assignedTo;
	
	@OneToMany(mappedBy="assignedTo")
	private Set<Volume> vols = new HashSet<>();
	
	@OneToMany
	@JoinColumn(name="WP_ID")
	private Set<Chapter> chaps = new HashSet<Chapter>();
	
	
	//Attribue un volume à un workPackage
	public boolean addVolume(Volume volume){
		Objects.requireNonNull(volume);
		return vols.add(volume);
	}
	
	//Attribue un chapitre au workpackage
	public boolean addChapter(Chapter chapterToAdd){
		Objects.requireNonNull(chapterToAdd);
		return chaps.add(chapterToAdd);
	}
	
	/**
	 * 
	 * @return la liste des chapites contenus dans ce WP
	 */
	
	public List<Chapter> getAllChapters(){
		return new ArrayList<>(chaps);
	}
	/**
	 * 
	 * @return la liste des volumes contenus dans ce WP
	 */
	public List<Volume> getAllVolumes(){
		return new ArrayList<>(vols);
	}
	//Recupère le statut courant du workpackage
	public WPMaturity.State getStatus(){
		return this.status;
	}
	
	//Ajouter un WorkPackage
	public void setStatus(WPMaturity.State status){
		this.status=status;
	}
	
	public void setAssignedTo(WorkSpace assignedTo) {
		this.assignedTo = assignedTo;
	}
	
	public WorkSpace getAssignedTo() {
		return assignedTo;
	}

}
