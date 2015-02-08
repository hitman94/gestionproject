package dao;

import entreprise.AbstractStructure;



/**
 * @author Florian
 * Extend AbstractDAO
 * Implémente des méthode spécifique à la dao des abstracte méthode
 * 
 */
public abstract class AbstractStructureDAO<E> extends AbstractDAO<E>{

	public AbstractStructureDAO(Class entity,String name) {
		super(entity,name);
	}
	
	
}
