package io.github.picoledelimao.mdl.test;

import org.junit.Assert;
import org.junit.Test;

import io.github.pcioledelimao.mdl.MDLVersion;

public class MDLVersionTest {

	@Test
	public void test() {
		String contents = "Version {\n\tFormatVersion 800,\n}\n";
		MDLVersion version = new MDLVersion();
		try {
			version.parse(contents);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertEquals(800, version.getFormatVersion(), 0);
		Assert.assertEquals(contents, version.toMDL());
		try {
			version.setFormatVersion(0);
			Assert.fail();
		} catch (Exception e) {
			
		}
	}

}
