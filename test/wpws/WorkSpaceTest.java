package wpws;

import org.junit.Assert;
import org.junit.Test;

public class WorkSpaceTest {

	/**
	 * test if we can add WS to WP
	 */
	@Test
	public void testAddedWPtoWS() {
		WorkPackage wp = new WorkPackage(null);
		WorkSpace ws = new WorkSpace(null);
		ws.addWP(wp);
		WorkPackage wp2 = ws.getWpList().get(0);
		Assert.assertTrue("wp et wp2 sont différents !", wp2 == wp);
	}

	/**
	 * test if we can remove WP to a WS
	 */
	@Test
	public void testRemovedWPtoWS() {
		WorkPackage wp = new WorkPackage(null);
		WorkSpace ws = new WorkSpace(null);
		ws.addWP(wp);
		Assert.assertTrue(ws.removeWP(wp));
		Assert.assertTrue(ws.getWpList().size()==0);
	}

	/**
	 * test if we get the right status
	 */
	@Test
	public void testWSStatus() {
		WorkSpace ws = new WorkSpace(null);
		WorkPackage wp1 = new WorkPackage(null);
		wp1.setStatus(WPMaturity.State.Start);
		WorkPackage wp2 = new WorkPackage(null);
		wp2.setStatus(WPMaturity.State.Start);
		WorkPackage wp3 = new WorkPackage(null);
		wp3.setStatus(WPMaturity.State.Start);		
		ws.addWP(wp1);
		ws.addWP(wp2);
		ws.addWP(wp3);
		
		Assert.assertTrue("La maturité du ws n'est pas Start !", ws.getWSMaturity() == WSMaturity.State.Start);
		
		wp1.setStatus(WPMaturity.State.Start);
		wp2.setStatus(WPMaturity.State.InProgress);
		wp3.setStatus(WPMaturity.State.InProgress);
		Assert.assertTrue("La maturité du ws n'est pas Start !", ws.getWSMaturity() == WSMaturity.State.Start);
		
		wp1.setStatus(WPMaturity.State.InProgress);
		wp2.setStatus(WPMaturity.State.InProgress);
		wp3.setStatus(WPMaturity.State.InProgress);		
		Assert.assertTrue("La maturité du ws n'est pas In Progress !", ws.getWSMaturity() == WSMaturity.State.InProgress);
		
		wp1.setStatus(WPMaturity.State.InProgress);
		wp2.setStatus(WPMaturity.State.Done);
		wp3.setStatus(WPMaturity.State.InProgress);		
		Assert.assertTrue("La maturité du ws n'est pas In Progress !", ws.getWSMaturity() == WSMaturity.State.InProgress);
		
		wp1.setStatus(WPMaturity.State.Done);
		wp2.setStatus(WPMaturity.State.Done);
		wp3.setStatus(WPMaturity.State.Done);		
		Assert.assertTrue("La maturité du ws n'est pas Done !", ws.getWSMaturity() == WSMaturity.State.Done);
	}

	
	/**
	 * test if status of WS change if condition of change id state : e.g do we
	 * get status inprogress after a promote on a WP for instance
	 * 
	 */
	@Test
	public void testIfWSStatusChange() {
		final WorkSpace ws = new WorkSpace(null);
		WorkPackage wp1 = new WorkPackage(null);
		wp1.setStatus(WPMaturity.State.InProgress);
		WorkPackage wp2 = new WorkPackage(null);
		wp2.setStatus(WPMaturity.State.InProgress);
			
		ws.addWP(wp1);
		ws.addWP(wp2);
		
		Assert.assertTrue(ws.getWSMaturity().equals(WSMaturity.State.InProgress));
		new Thread(new Runnable() {
			
			public void run() {
				WorkPackage wp3 = new WorkPackage(null);
				wp3.setStatus(WPMaturity.State.Start);
				ws.addWP(wp3);
				
			}
		}).start();
		Assert.assertTrue(ws.getWSMaturity().equals(WSMaturity.State.Start));
	}

}
