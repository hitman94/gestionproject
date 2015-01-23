	package Comportement;
	
	public class PatronAbility {
		//Creer un volume en donnant son titre
		public Volume createVolume(String title){}
		//Ajoute un volume à un WP
		public boolean addVolumeToWP(Volume v,WorkPackage p){}
		//Creer une entrprise la renvoie renvoie null si echec
		public Company createCompany(String name){}
		//Attribut un workpackage à une entreprise
		public boolean addWPToCompany(Workpackage wp, Company c){}
		//Attribut un chef à une entreprise
		public boolean nominateCompanyChief(User u, Company c){}
		//Creer un livre avec son nom
		public boolean createBook(String name){}
	}
