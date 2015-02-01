package wpws;



import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import livre.Book;
import livre.Chapter;
import livre.ChapterInterface;
import livre.SubChapter;
import livre.Volume;

public class WorkPackage {
	
	private Set<Book> lBooks = new HashSet<Book>();
	private Map<Volume,Set<Chapter>> mVol = new HashMap<>();
	private Map<Chapter,Set<SubChapter>> mChap = new  HashMap<>();
	
	//Attribue un livre à un workPackage
	public void addBook(Book book){
		Objects.requireNonNull(book);
		lBooks.add(book);
	}
	
	//Attribue un volume à un workPackage
	public void addVolume(Volume volume){
		Objects.requireNonNull(volume);
		if(mVol.get(volume)!=null) {
			mVol.put(volume, new HashSet<Chapter>());
		}
	}
	
	//Attribue un chapitre à un volume
	public void addChapterToVolume(Chapter chapterToAdd,Volume volume){
		
		Objects.requireNonNull(volume);
		Objects.requireNonNull(chapterToAdd);
		Set<Chapter> sChapter = mVol.get(volume);
		if(sChapter !=null) {
			if(sChapter.add(chapterToAdd))
				mChap.put(chapterToAdd, new HashSet<SubChapter>());
		} else {
			throw new IllegalArgumentException();
		}
	}
	//Attribue un sous chapitre a un chapitre
	public void addSubChapterToChapter(SubChapter subToAdd,Chapter chapter){
		Objects.requireNonNull(subToAdd);
		Objects.requireNonNull(chapter);
		Set<SubChapter> sSubChapter = mChap.get(subToAdd);
		if(sSubChapter!=null)
			sSubChapter.add(subToAdd);
		else
			throw new IllegalArgumentException();
	}
	//recupère une liste de chapitre ou de sous chapitre
	//Si SubChapterNumber different de -1 recupère le sous chapitre appartenant correspondant au chapterNumber
	//sinon recupere tous le chapitre
	public List<ChapterInterface> getChapterInterfaceByNumber(int chapterNumber,int subChapterNumber){}
//recupère le volume dont le titre est donné en paramètre
	public Volume getVolume(String title){}
	//Recupère le statut courant du workpackage
	public WPMaturity.State getWPMaturity(){}
	
	//Ajouter un WorkPackage
	public WPMaturity.State addWPMaturity(){}

}
