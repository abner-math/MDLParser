package io.github.picoledelimao.mdl.test;

import org.junit.Assert;
import org.junit.Test;

import io.github.picoledelimao.mdl.MDLAnim;

public class MDLAnimTest {

	@Test
	public void test() {
		String anim1 = "Anim \"Stand\" {\n\tInterval { 100.1, 1600 },\n\tMinimumExtent { -132, -129, -0.605469 },\n\tMaximumExtent { 128, 131, 206 },\n\tBoundsRadius 184.026,\n}\n";
		String anim2 = "Anim \"Attack - 1\" {\n\tInterval { 4000, 5000 },\n\tRarity 100,\n\tMoveSpeed 100,\n\tNonLooping,\n\tMinimumExtent { -132, -129, -0.605469 },\n\tMaximumExtent { 128, 131, 206 },\n\tBoundsRadius 184.026,\n}\n";
		MDLAnim a1 = new MDLAnim();
		try {
			a1.parse(anim1);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertEquals(anim1, a1.toMDL());
		Assert.assertArrayEquals(new Float[]{100.1f, 1600f}, a1.getInterval());
		Assert.assertArrayEquals(new Float[]{-132f, -129f, -0.605469f}, a1.getMinimumExtent());
		Assert.assertArrayEquals(new Float[]{128f, 131f, 206f}, a1.getMaximumExtent());
		Assert.assertEquals(184.026f, a1.getBoundsRadius(), 0);
		Assert.assertEquals(0, a1.getMoveSpeed(), 0);
		Assert.assertEquals(0, a1.getRarity(), 0);
		Assert.assertFalse(a1.isNonLooping());
		Assert.assertEquals("\"Stand\"", a1.getValue());
		MDLAnim a2 = new MDLAnim();
		try {
			a2.parse(anim2);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertEquals(anim2, a2.toMDL());
		Assert.assertArrayEquals(new Float[]{4000f, 5000f}, a2.getInterval());
		Assert.assertArrayEquals(new Float[]{-132f, -129f, -0.605469f}, a2.getMinimumExtent());
		Assert.assertArrayEquals(new Float[]{128f, 131f, 206f}, a2.getMaximumExtent());
		Assert.assertEquals(184.026f, a2.getBoundsRadius(), 0);
		Assert.assertEquals(100, a2.getMoveSpeed(), 0);
		Assert.assertEquals(100, a2.getRarity(), 0);
		Assert.assertTrue(a2.isNonLooping());
		Assert.assertEquals("\"Attack - 1\"", a2.getValue());
	}

}
