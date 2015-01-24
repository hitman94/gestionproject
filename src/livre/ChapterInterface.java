package livre;

import java.util.List;

public interface ChapterInterface {
	
	/*
	 * R�cup�re la liste des paragraphes
	 * contenus dans une ChapterInterface.
	 */
	public List<Paragraph> getParagraphs();
	
	/*
	 * Ajoute un Paragraph � une ChapterInterface.
	 */
	public void addParagraph(Paragraph paragraph);
	
	/*
	 * Attribue un Volume � une ChapterInterface.
	 */
	public void setVolume(Volume volume);

}
