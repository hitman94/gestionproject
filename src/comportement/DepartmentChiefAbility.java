package comportement;

import livre.Chapter;
import livre.SubChapter;
import wpws.WorkPackage;
import entreprise.Service;

public class DepartmentChiefAbility {
	//Creer un service avec son nom, renvoie null si echec
	public Service createService(String name){}
	//Attribue un chef de service à un service donné
	public boolean setServiceChief(User u, Service s){}
	//Creer un sous chapitre dans un chapitre, renvoie null si echec
	public SubChapter createSubChapter(String name, Chapter c){}
//Attribut un sous chapitre à un WP
	public boolean addSubChapterToWP(SubChapter sc, WorkPackage w){}

}
