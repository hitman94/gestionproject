package wpws;



import java.util.List;

import livre.Book;
import livre.Chapter;
import livre.ChapterInterface;
import livre.SubChapter;
import livre.Volume;

public class WorkPackage {
	//Attribue un livre à un workPackage
	public void addBook(Book book){}
	//Attribue un volume à un workPackage
	public void addVolume(Volume volume){}
	//Attribue un chapitre à un volume
	public void addChapterToVolume(Chapter chapterToAdd,Volume volume){}
	//Attribue un sous chapitre a un chapitre
	public void addSubChapterToChapter(SubChapter subToAdd,Chapter chapter){}
	//recupère une liste de chapitre ou de sous chapitre
	//Si SubChapterNumber different de -1 recupère le sous chapitre appartenant correspondant au chapterNumber
	//sinon recupere tous le chapitre
	public List<ChapterInterface> getChapterInterfaceByNumber(int chapterNumber,SubChapterNumber number){}
//recupère le volume dont le titre est donné en paramètre
	public Volume getVolume(String title){}
	//Recupère le statut courant du workpackage
	public WPMaturity.State getWPMaturity(){}
	
	//Ajouter un WorkPackage
	public WPMaturity.State addWPMaturity(){}
	
	//Recupère tous les WP du WS
	public List<WP> getWPList(){}
}
