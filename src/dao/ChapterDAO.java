package dao;

import javax.ejb.Stateless;
import javax.inject.Named;

import livre.Chapter;
@Stateless
@Named
public class ChapterDAO extends AbstractDAO<Chapter> {

	public ChapterDAO() {
		super(Chapter.class, "Chapter");
	}

}
