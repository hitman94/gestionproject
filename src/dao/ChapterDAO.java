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
			for(Chapter c : result) {
				if(c.getTakenDate()!=-1 && c.getTakenDate() != -2) {
					if( (System.currentTimeMillis()-604800) > c.getTakenDate() ) {
						
						c.setTakenDate(-1L);
						update(c);
					}
				}
			}
			return result;
		} catch (NoResultException e) {
			return null;
		} 
	}
	
	public List<Chapter> editedChapterFromEntreprise(Long id) {
		Query q = em.createQuery("SELECT c FROM Chapter c WHERE c.wp.assignedTo.ent.id=:id AND c.takenDate!=-1 AND c.takenDate!=-2");
		q.setParameter("id", id);
		try {
			List<Chapter> result = q.getResultList();
			return result;
		} catch (NoResultException e) {
			return null;
		} 
	}
	
	public List<Chapter> promotedChapterFromEntreprise(Long id) {
		Query q = em.createQuery("SELECT c FROM Chapter c WHERE c.wp.assignedTo.ent.id=:id AND c.takenDate=-2 ORDER BY c.wp.id");
		q.setParameter("id", id);
		try {
			List<Chapter> result = q.getResultList();
			return result;
		} catch (NoResultException e) {
			return null;
		} 
	}
	
	public boolean chapterNumberInVolumeCheck(Long numberInVolume,Long volume) {
		Query q = em.createQuery("SELECT c FROM Chapter c WHERE c.numberInVolume=:numberInVolume AND c.volume.id=:volumeId");
		q.setParameter("numberInVolume", numberInVolume);
		q.setParameter("volumeId", volume);
		try {
			q.getSingleResult();
			return true;
		}catch (NoResultException e){
			return false;
		}
	}
	
	public List<Chapter> chapterFroWp(Long id) {
		Query q = em.createQuery("SELECT c FROM Chapter c WHERE c.wp.id=:id AND c.takenDate != -2");
		q.setParameter("id", id);
		try {
			List<Chapter> result = q.getResultList();
			return result;
		} catch (NoResultException e) {
			return null;
		} 
	}

}
