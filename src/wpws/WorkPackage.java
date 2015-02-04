package wpws;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import livre.Book;
import livre.Chapter;
import livre.SubChapter;
import livre.Volume;

public class WorkPackage {
	
	private WPMaturity.State status;
	private Set<Book> lBooks = new HashSet<Book>();
	private Set<Volume> vols = new HashSet<>();
	private Set<Chapter> chaps = new HashSet<Chapter>();
	private Set<SubChapter> subChaps = new HashSet<SubChapter>();
	
	//Attribue un livre à un workPackage
	public void addBook(Book book){
		Objects.requireNonNull(book);
		lBooks.add(book);
	}
	
	//Attribue un volume à un workPackage
	public void addVolume(Volume volume){
		Objects.requireNonNull(volume);
		vols.add(volume);
	}
	
	//Attribue un chapitre au workpackage
	public void addChapter(Chapter chapterToAdd){
		
		Objects.requireNonNull(chapterToAdd);
		chaps.add(chapterToAdd);
	}
	
	
	//Attribue un sous chapitre au workpackage
	public void addSubChapter(SubChapter subToAdd){
		Objects.requireNonNull(subToAdd);
		subChaps.add(subToAdd);
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
	 * @return la liste des sous chapites contenus dans ce WP
	 */
	
	public List<SubChapter> getAllSubChapters() {
		return new ArrayList<>(subChaps);
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

}
