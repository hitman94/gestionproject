package dao;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



/**
 * @author Florian
 *	Super class d'une DAO sp�cifique
 *	Definie les m�thodes commune � chaques DAO
 * @param <E>
 *	
 */
@Stateless
@Named
public abstract class AbstractDAO<E> {

	protected Class<E> entity;
	protected String entityName;
	
	@PersistenceContext(unitName = "gestionproject")
	protected EntityManager em;
	
	
	public AbstractDAO(Class<E> entity,String entityname) {
		this.entity = entity;
		this.entityName=entityname;
	}
	
	public void persist(E entity){
		em.persist(entity);
	}
	
	public void remove(E entity){
		em.remove(entity);
	}
	
	public E findById(Long id){
		return em.find(entity, id);
	}
	
	public Collection<E> findAll(){
		Query q = em.createQuery("Select E From "+ entityName + " E");
		return q.getResultList();
		
	}
	
	public E update(E entity){
		return em.merge(entity);
	}
}
