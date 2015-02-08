package livre;

import java.util.List;

import javax.persistence.Entity;

@Entity
public interface ChapterInterface {
	
	/*
	 * Récupère la liste des paragraphes
	 * contenus dans une ChapterInterface.
	 */
	public List<Paragraph> getParagraphs();
	
	/*
	 * Ajoute un Paragraph à une ChapterInterface.
	 */
	public void addParagraph(Paragraph paragraph);
	
	/*
	 * Supprime un Paragraph d'une ChapterInterface.
	 */
	public void removeParagraph(Paragraph paragraph);
	
	/*
	 * Récupère le Volume qui contient la ChapterInterface.
	 */
	public Volume getVolume();
	
	/*
	 * Attribue un Volume à une ChapterInterface.
	 */
	public void setVolume(Volume volume);

}
