package dao;

import entreprise.Entreprise;

public class EntrepriseDAO extends AbstractDAO<Entreprise>{
	
	public EntrepriseDAO() {
		super(Entreprise.class,"Entreprise");
	}

}
