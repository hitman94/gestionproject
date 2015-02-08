package dao;

import entreprise.Entreprise;

public class EntrepriseDAO extends AbstractStructureDAO<Entreprise>{
	
	public EntrepriseDAO() {
		super(Entreprise.class,"Entreprise");
	}

}
