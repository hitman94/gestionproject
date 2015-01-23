package Comportement;

import java.awt.List;

import WorkPackage_WorkSpace.WorkPackage;

public class Ability {
	//Recupere la liste des workPackage qui nous a été affectée
	public List<WorkPackage> acquire(){}
	//Recupere la liste des workPackage qu’on a affecté
	public List<WorkPackage> collect(){}
	//Promo un workpackage dans le WS père
	public boolean promote(WorkPackage p){}
	//Met a jour les WP ayant été accepté après un collect
	public boolean synchronize(){}
	//Creer un workSpace, renvoie null si echec
	public WorkSpace createWS(){}
	
}
