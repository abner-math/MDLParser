package io.github.picoledelimao.mdl.test;

import org.junit.Assert;
import org.junit.Test;

import io.github.picoledelimao.mdl.core.MDLBoolean;

public class MDLBooleanTest {

	@Test
	public void test() {
		String s1 = "Test1,";
		MDLBoolean b1 = new MDLBoolean("Test1");
		try {
			b1.parse(s1);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertTrue(b1.getValue());
		Assert.assertEquals("Test1,", b1.toMDL());
		String s2 = "Test1,Test2,";
		MDLBoolean b2 = new MDLBoolean("Test3");
		try {
			b2.parse(s2);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertFalse(b2.getValue());
		Assert.assertEquals("", b2.toMDL());
		String s3 = "Test1,       Test2, Test11    , ";
		MDLBoolean b3 = new MDLBoolean("Test11");
		try {
			b3.parse(s3);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertTrue(b3.getValue());
		Assert.assertEquals("Test11,", b3.toMDL());
	}

}
