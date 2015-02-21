package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.TypedQuery;

import utilisateur.User;
import entreprise.Entreprise;

@Stateless
@Named
public class EntrepriseDAO extends AbstractDAO<Entreprise>{
	
	public EntrepriseDAO() {
		super(Entreprise.class,"Entreprise");
	}
	
	

}
