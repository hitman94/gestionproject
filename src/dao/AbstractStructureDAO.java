package dao;

import entreprise.AbstractStructure;



/**
 * @author Florian
 * Extend AbstractDAO
 * Impl�mente des m�thode sp�cifique � la dao des abstracte m�thode
 * 
 */
public abstract class AbstractStructureDAO<E> extends AbstractDAO<E>{

	public AbstractStructureDAO(Class entity,String name) {
		super(entity,name);
	}
	
	
}
