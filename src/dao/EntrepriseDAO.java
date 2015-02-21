package dao;

import javax.ejb.Stateless;
import javax.inject.Named;

import entreprise.Entreprise;

@Stateless
@Named
public class EntrepriseDAO extends AbstractDAO<Entreprise>{
	
	public EntrepriseDAO() {
		super(Entreprise.class,"Entreprise");
	}

}
