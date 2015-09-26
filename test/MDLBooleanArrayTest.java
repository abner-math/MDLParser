

import org.junit.Assert;
import org.junit.Test;

import io.github.picoledelimao.mdl.core.MDLBooleanArray;

public class MDLBooleanArrayTest {

	@Test
	public void test() {
		String test1 = "a { ana, carlos, diego },\n";
		MDLBooleanArray arr1 = new MDLBooleanArray("a", "ana", "carlos", "diego", "pedro");
		try {
			arr1.parse(test1);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertEquals(test1, arr1.toMDL());
		String test2 = "b { },\n";
		MDLBooleanArray arr2 = new MDLBooleanArray("a", "kadu");
		try {
			arr2.parse(test2);
		} catch (Exception e) { }
		Assert.assertEquals("", arr2.toMDL());
	}

}
