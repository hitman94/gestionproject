package wpws;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

public class WorkSpaceTest {

	
	/**
	 * test if we can add WS to WP
	 */
	@Test
	public void testAddedWPtoWS() {
		WorkPackage wp = new WorkPackage();
		WorkSpace ws = new WorkSpace();
		ws.addWP(wp);
		Assert.assertTrue(ws.getWpList().get(0).equals(wp));
	}

	/**
	 * test if we can remove WP to a WS
	 */
	@Test
	public void testRemovedWPtoWS() {
		WorkPackage wp = new WorkPackage();
		WorkSpace ws = new WorkSpace();
		ws.addWP(wp);
		Assert.assertTrue(ws.removeWP(wp));
		Assert.assertTrue(ws.getWpList().size()==0);
	}

	/**
	 * test if we get the right status
	 */
	@Test
	public void testWSStatus() {
		WorkSpace ws = new WorkSpace();
		WorkPackage wp1 = new WorkPackage();
		wp1.setStatus(WSMaturity.State.Start);
		WorkPackage wp2 = new WorkPackage();
		wp2.setStatus(WSMaturity.State.Start);
		WorkPackage wp3 = new WorkPackage();
		wp3.setStatus(WSMaturity.State.Start);		
		ws.addWP(wp1);
		ws.addWP(wp2);
		ws.addWP(wp3);
		
		Assert.assertTrue(ws.getWSMaturity().equals(WSMaturity.State.Start));
		wp1.setStatus(WSMaturity.State.Start);
		wp2.setStatus(WSMaturity.State.InProgress);
		wp3.setStatus(WSMaturity.State.InProgress);
		Assert.assertTrue(ws.getWSMaturity().equals(WSMaturity.State.Start));
		wp1.setStatus(WSMaturity.State.InProgress);
		wp2.setStatus(WSMaturity.State.InProgress);
		wp3.setStatus(WSMaturity.State.InProgress);		
		Assert.assertTrue(ws.getWSMaturity().equals(WSMaturity.State.InProgress));
		wp1.setStatus(WSMaturity.State.InProgress);
		wp2.setStatus(WSMaturity.State.Done);
		wp3.setStatus(WSMaturity.State.InProgress);		
		Assert.assertTrue(ws.getWSMaturity().equals(WSMaturity.State.InProgress));
		wp1.setStatus(WSMaturity.State.Done);
		wp2.setStatus(WSMaturity.State.Done);
		wp3.setStatus(WSMaturity.State.Done);		
		Assert.assertTrue(ws.getWSMaturity().equals(WSMaturity.State.Done));
		
		
	}

	
	/**
	 * test if status of WS change if condition of change id state : e.g do we
	 * get status inprogress after a promote on a WP for instance
	 * 
	 */
	@Test
	public void testIfWSStatusChange() {
		final WorkSpace ws = new WorkSpace();
		WorkPackage wp1 = new WorkPackage();
		wp1.setStatus(WSMaturity.State.InProgress);
		WorkPackage wp2 = new WorkPackage();
		wp2.setStatus(WSMaturity.State.InProgress);
			
		ws.addWP(wp1);
		ws.addWP(wp2);
		
		Assert.assertTrue(ws.getWSMaturity().equals(WSMaturity.State.InProgress));
		new Thread(new Runnable() {
			
			public void run() {
				WorkPackage wp3 = new WorkPackage();
				wp3.setStatus(WSMaturity.State.Start);
				ws.addWP(wp3);
				
			}
		}).start();
		Assert.assertTrue(ws.getWSMaturity().equals(WSMaturity.State.Start));
		
	}
	
	

}
