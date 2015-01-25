package test.DAO;

import static org.junit.Assert.*;
import livre.Book;

import org.junit.Test;

import wpws.WorkPackage;

public class WorkPackageDAOTest {

	@Test
	public void addAndGetWorkPackageTest() {
		WorkPackage w = new WorkPackage("id");
		saveWorkPackage(w);
		WorkPackage w2 = getWorkPackageById("id");
		assertEquals("w et w2 sont different",w.getID(), w.getID());
	}
	
	@Test
	public void deleteWorkPackageUser() {
		WorkPackage w = new WorkPackage("id");
		saveWorkPackage(w);
		deleteWorkPackage(w);
		WorkPackage w2 = WorkPackage("id");
		assertNull("w2 non null: delete raté",w2);
	}
	
	@Test
	public void updateWorkPackageTest() {
		WorkPackage w = new WorkPackage("id");
		saveWorkPackage(w);
		w.addBook(new Book(new Long(123), "test", "author"));;
		updateWorkPackage(w);
		WorkPackage w2 = getWorkPackageById("id");
		assertNull("w2 null: update raté",w2);
		assertEquals("Nom de w2 different de Bob, update raté","test", w.getVolume("title").getTitle() );
	}
	

}
