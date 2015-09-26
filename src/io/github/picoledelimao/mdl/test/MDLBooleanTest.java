package io.github.picoledelimao.mdl.test;

import org.junit.Assert;
import org.junit.Test;

import io.github.picoledelimao.mdl.core.MDLBoolean;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;

public class MDLBooleanTest {

	@Test
	public void test() throws MDLParserErrorException {
		String s1 = "Test1,";
		MDLBoolean b1 = new MDLBoolean("Test1");
		b1.parse(s1);
		Assert.assertTrue(b1.getValue());
		Assert.assertEquals("Test1,\n", b1.toMDL());
		String s2 = "Test1,Test2,";
		MDLBoolean b2 = new MDLBoolean("Test3");
		b2.parse(s2);
		Assert.assertFalse(b2.getValue());
		Assert.assertEquals("", b2.toMDL());
		String s3 = "Test1,       Test2, Test11    , ";
		MDLBoolean b3 = new MDLBoolean("Test11");
		b3.parse(s3);
		Assert.assertTrue(b3.getValue());
		Assert.assertEquals("Test11,\n", b3.toMDL());
	}

}
