package livre;

import java.util.List;

public interface ChapterInterface {
	
	/*
	 * Récupére la liste des paragraphes
	 * contenus dans une ChapterInterface.
	 */
	public List<Paragraph> getParagraphs();
	
	/*
	 * Ajoute un Paragraph à une ChapterInterface.
	 */
	public void addParagraph(Paragraph paragraph);
	
	/*
	 * Attribue un Volume à une ChapterInterface.
	 */
	public void setVolume(Volume volume);

}
