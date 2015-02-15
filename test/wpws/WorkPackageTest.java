package wpws;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import livre.Chapter;
import livre.Volume;

import org.junit.*;

public class WorkPackageTest {
	@Test(expected = IllegalArgumentException.class)
	public void test2Volume(){
		//tester qu'on a pas 2 volume idem
		WorkPackage wp= new WorkPackage();
		Volume v = new Volume("volume 1");
		wp.addVolume(v);
		wp.addVolume(v);
		List<Volume>l=wp.getAllVolumes();
		if(l.indexOf(0)==l.indexOf(1))
			throw new IllegalArgumentException();
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAdd2Chapitre(){
		//tester qu'on a pas 2 chapitre idem
		WorkPackage wp= new WorkPackage();
		Volume v = new Volume("volume 1");
		Chapter c = new Chapter("Chapitre 1",v);
		wp.addChapter(c);
		wp.addChapter(c);
		List<Chapter>l=wp.getAllChapters();
		if(l.indexOf(0)==l.indexOf(1))
			throw new IllegalArgumentException();
	}

	//Verifie que le bon volume est recupéré
	@Test
	public void TestGetVolume(){
		WorkPackage wp= new WorkPackage();
		Volume v = new Volume("volume 1");
		Chapter c1 = new Chapter("Chapitre 1",v);
		Chapter c2 = new Chapter("Chapitre 2",v);
		wp.addChapter(c1);
		assertEquals("volume 1",c1.getVolume().getTitle());
		assertEquals("volume 1",c2.getVolume().getTitle());
	}
	//Tester que les changements de statut du WP sont effectués correctement.
	@Test
	public void testIfWPStatusChange() {

	}

}
