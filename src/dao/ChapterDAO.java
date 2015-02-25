package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import livre.Chapter;
@Stateless
@Named
public class ChapterDAO extends AbstractDAO<Chapter> {

	public ChapterDAO() {
		super(Chapter.class, "Chapter");
	}
	
	public List<Chapter> chapterFromEntreprise(Long id) {
		Query q = em.createQuery("SELECT c FROM Chapter c WHERE c.wp.assignedTo.ent.id=:id");
		q.setParameter("id", id);
		try {
			List<Chapter> result = q.getResultList();
			return result;
		} catch (NoResultException e) {
			return null;
		} 
	}
	
	public List<Chapter> editedChapterFromEntreprise(Long id) {
		Query q = em.createQuery("SELECT c FROM Chapter c WHERE c.wp.assignedTo.ent.id=:id AND c.takenDate!=-1");
		q.setParameter("id", id);
		try {
			List<Chapter> result = q.getResultList();
			return result;
		} catch (NoResultException e) {
			return null;
		} 
	}
	
	public List<Chapter> chapterFroWp(Long id) {
		Query q = em.createQuery("SELECT c FROM Chapter c WHERE c.wp.id=:id");
		q.setParameter("id", id);
		try {
			List<Chapter> result = q.getResultList();
			return result;
		} catch (NoResultException e) {
			return null;
		} 
	}

}
