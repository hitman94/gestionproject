package comportement;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import utilisateur.User;
import wpws.WorkPackage;
import livre.Chapter;
import livre.SubChapter;
import livre.Volume;
import entreprise.Department;
import entreprise.Entreprise;
import entreprise.Service;

public class CompanyChiefAbility extends Ability{
	
	private List<Department> list = new ArrayList<Department>();
	
	//Creer un departement avec son nom, renvoie null si echec
	public Department createDepartment(String name){
		Department d = new Department(name);
		list.add(d);
		return d;
	}
	//Affecte un chef de departement à un departement
	public boolean setDepartmentChief(User u, Department d){
		for(Department dep:list) {
			if(dep.equals(d)) {
				dep.setChief(u);
				return true;
			}
		}
		return false;
	}
	//Creer un utilisateur avec son nom et mot de passe, renvoie null si échec
	public User createUser(String name,String pass,List<Ability> ability){
		return new User(name,pass,ability);
	}
	//Ajoute un wp à un département
	public boolean addWPToDepartment(WorkPackage wp, Department d){
		for(Department dep:list) {
			if(dep.equals(d)) {
				dep.getWorkSpace().addWP(wp);
				return true;
			}
		}
		return false;
	}
	//Creer un chapitre, renvoie null si echec
	public Chapter createChapter(String name){
		return new Chapter(name, User.getUsername());
	}
	//Attribut un chapitre à un WP
	public boolean addChapterToWP(Chapter c, WorkPackage WP){
		WP.addChapter(c);
		return true;
	}
	



	@Override
	public List<File> getFiles() {
		throw new UnsupportedOperationException();
	}
	@Override
	public Service createService(String name) {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean setServiceChief(User u, Service s) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean addSubChapterToWP(SubChapter sc, WorkPackage w) {
		throw new UnsupportedOperationException();
	}
	@Override
	public void createGroup(String name) {
		throw new UnsupportedOperationException();
	}
	
	
	@Override
	public void retreivePromotionBean() {
		throw new UnsupportedOperationException();
	}
	@Override
	public void assignWPToGroup(Long WPUI, String name) {
		throw new UnsupportedOperationException();
	}
	@Override
	public Volume createVolume(String title) {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean addVolumeToWP(Volume v, WorkPackage p) {
		throw new UnsupportedOperationException();
	}
	@Override
	public Entreprise createCompany(String name) {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean addWPToCompany(WorkPackage wp, Entreprise c) {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean nominateCompanyChief(User u, Entreprise c) {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean createBook(String name) {
		throw new UnsupportedOperationException();
	}

}
