package dao;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.AbstractStructureDAO;
import entreprise.Entreprise;

public class AbstractStructureDAOTest {
	private AbstractStructureDAO dao;

	@Test
	public void addAndGetAbstractStructureTest() {
		AbstractStructure a = new Entreprise("Air France");
		dao.saveAbstractStructure(a);
		AbstractStructure a2 = dao.getUserById("Dupont");
		assertEquals("u et u2 sont different",u.getNom(), u2.getNom());
	}
	
	@Test
	public void deleteAbstractStructureTest() {
		AbstractStructure u = new Entreprise("Air France");
		dao.saveAbstractStructure(u);
		dao.deleteUser(u);
		AbstractStructure u2 = getUserById("Air France"");
		assertNull("u2 non null: delete rat�"u2);
	}
	
	@Test
	public void updateAbstractStructureTest() {
		AbstractStructure u = new Entreprise("Air France");
		dao.saveAbstractStructure(u);
		u.setNom("Malaysia Airlines");
		dao.updateAbstractStructure(u);
		AbstractStructure u2 = dao.getAbstractStructureDAOById("Malaysia Airlines");
		assertNull("u2 null: update rat�"u2);
		assertEquals("Nom de u2 different de Bob, update rat�","Malaysia Airlines" u2.getNom());
	}
	
	@Test
	public void findAllTest() {
		AbstractStructure abstract1 = new Entreprise("Air france");
		AbstractStructure abstract2 = new Entreprise("Malaysia Airlines");
		AbstractStructure abstract3 = new Entreprise("Air Italia");
		AbstractStructure abstract4 = new Entreprise("qatar airways");
		dao.saveAbstractStructure(abstract1);
		dao.saveAbstractStructure(abstract2);
		dao.saveAbstractStructure(abstract3);
		dao.saveAbstractStructure(abstract4);
		assertEquals("4", findAll().size());
	}
}
