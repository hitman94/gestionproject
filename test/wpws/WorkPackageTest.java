package wpws;

import static org.junit.Assert.assertEquals;
import livre.Chapter;
import livre.Volume;

import org.junit.Assert;
import org.junit.Test;

public class WorkPackageTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void test2Volume(){
		//tester qu'on a pas 2 volume idem
		WorkPackage wp = new WorkPackage(null);
		Volume v = new Volume("volume 1", wp);
		wp.addVolume(v);
		wp.addVolume(v);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAdd2Chapitre(){
		//tester qu'on a pas 2 chapitre idem
		WorkPackage wp = new WorkPackage(null);
		Volume v = new Volume("volume 1", wp);
		Chapter c = new Chapter("Chapitre 1",v);
		wp.addChapter(c);
		wp.addChapter(c);
	}

	//Verifie que le bon volume est recupéré
	@Test
	public void testGetVolume(){
		WorkPackage wp = new WorkPackage(null);
		Volume v = new Volume("volume 1", wp);
		Chapter c1 = new Chapter("Chapitre 1",v);
		Chapter c2 = new Chapter("Chapitre 2",v);
		wp.addChapter(c1);
		assertEquals("volume 1",c1.getVolume().getTitle());
		assertEquals("volume 1",c2.getVolume().getTitle());
	}
	
	//Tester que les changements de statut du WP sont effectués correctement.
	@Test
	public void testIfWPStatusChange() {
		final WorkSpace ws = new WorkSpace(null);
		WorkPackage wp1 = new WorkPackage(null);
		wp1.setStatus(WPMaturity.State.InProgress);
		WorkPackage wp2 = new WorkPackage(null);
		wp2.setStatus(WPMaturity.State.InProgress);

		ws.addWP(wp1);
		ws.addWP(wp2);

		Assert.assertTrue(ws.getWSMaturity().equals(WSMaturity.State.InProgress));
	}
}
