

import org.junit.Assert;
import org.junit.Test;

import io.github.picoledelimao.mdl.core.MDLString;

public class MDLStringTest {

	@Test
	public void test() {
		String s1 = "ss1\"testing...\",";
		MDLString ms1 = new MDLString("ss1", true);
		try {
			ms1.parse(s1);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertEquals("testing...", ms1.getValue());
		Assert.assertEquals("ss1 \"testing...\",\n", ms1.toMDL());
		String s2 = "ss2         \"\",";
		MDLString ms2 = new MDLString("ss2", true);
		try {
			ms2.parse(s2);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertEquals("", ms2.getValue());
		Assert.assertEquals("ss2 \"\",\n", ms2.toMDL());
		ms2.setValue("hi");
		Assert.assertEquals("ss2 \"hi\",\n", ms2.toMDL());
		ms2.setValue("");
		Assert.assertEquals("", ms2.getValue());
		MDLString ms3 = new MDLString("NotFound", false);
		try {
			ms3.parse(s2);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertEquals(null, ms3.getValue());
		Assert.assertEquals("", ms3.toMDL());
		ms3.setValue("abc");
		Assert.assertEquals("abc", ms3.getValue());
		Assert.assertEquals("NotFound \"abc\",\n", ms3.toMDL());
		ms3.setValue("");
		Assert.assertEquals("", ms3.toMDL());
	}

}
