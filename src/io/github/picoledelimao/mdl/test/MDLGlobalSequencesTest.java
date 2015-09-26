package io.github.picoledelimao.mdl.test;

import org.junit.Assert;
import org.junit.Test;

import io.github.picoledelimao.mdl.MDLGlobalSequences;

public class MDLGlobalSequencesTest {

	@Test
	public void test() throws NoSuchMethodException, SecurityException {
		String sequences1 = "GlobalSequences 1 {\n\tDuration 100,\n}\n";
		String sequences2 = "GlobalSequences 2 {\n\tDuration 3333,\n\tDuration 1600,\n}\n";
		MDLGlobalSequences gs1 = new MDLGlobalSequences();
		try {
			gs1.parse(sequences1);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertEquals(sequences1, gs1.toMDL());
		MDLGlobalSequences gs2 = new MDLGlobalSequences();
		try {
			gs2.parse(sequences2);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertEquals(sequences2, gs2.toMDL());
	}

}
