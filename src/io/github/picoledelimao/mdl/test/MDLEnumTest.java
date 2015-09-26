package io.github.picoledelimao.mdl.test;

import org.junit.Assert;
import org.junit.Test;

import io.github.picoledelimao.mdl.core.MDLEnum;
import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;

public class MDLEnumTest {

	@Test
	public void test() throws MDLParserErrorException, MDLNotFoundException {
		String easy1Correct = "Linear,";
		MDLEnum e1 = new MDLEnum("", true, "None", "Linear", "Hermite", "Bezier") { };
		e1.parse(easy1Correct);
		Assert.assertEquals("Linear", e1.getValue());
		Assert.assertEquals("None", e1.getDefaultValue());
		e1.setRequired(false);
		e1.setValue("None");
		Assert.assertEquals("", e1.toMDL());
		e1.setRequired(true);
		Assert.assertEquals("None,\n", e1.toMDL());
		try {
			e1.setValue("NotFound");
			Assert.fail();
		} catch (Exception e) { }
		try {
			e1.setAllowedValues(new String[]{"a", "b", "b", "c"});
		} catch (Exception e) { }
		MDLEnum e2 = new MDLEnum("", false, "A", "B", "C") { };
		try {
			e2.parse(easy1Correct);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertEquals("", e2.toMDL());
		Assert.assertEquals("A", e2.getValue());
		Assert.assertEquals("A", e2.getDefaultValue());
		e2.setDefaultValue("D");
		Assert.assertEquals("A,\n", e2.toMDL());
		try {
			e2.setDefaultValue("C");
			Assert.fail();
		} catch (Exception e) { }
		try {
			e2.setDefaultValue("A");
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

}
