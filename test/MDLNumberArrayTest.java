

import org.junit.Assert;
import org.junit.Test;

import io.github.picoledelimao.mdl.core.MDLNumberArray;

public class MDLNumberArrayTest {

	@Test
	public void test() {
		String easy1 = "arr1{10,20,30},";
		MDLNumberArray<Integer> e1 = new MDLNumberArray<>("arr1", Integer.class, 3);
		try {
			e1.parse(easy1);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertArrayEquals(new Integer[]{10,  20, 30}, e1.getValues());
		Assert.assertEquals("arr1 { 10, 20, 30 },\n", e1.toMDL());
		String easy2 = "array1{8}, array3 { -5,8.9}, ";
		MDLNumberArray<Double> e2 = new MDLNumberArray<>("array3", Double.class, 2);
		try {
			e2.parse(easy2);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertArrayEquals(new Double[]{-5.0,  8.9}, e2.getValues()); 
		Assert.assertEquals("array3 { -5, 8.9 },\n", e2.toMDL());
		String medium1 = "aa { 8 }, aaa { 10 }, a{ 5 },";
		MDLNumberArray<Integer> m1 = new MDLNumberArray<>("a", Integer.class, 1);
		try {
			m1.parse(medium1);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertArrayEquals(new Integer[]{5}, m1.getValues());
		Assert.assertEquals("a { 5 },\n", m1.toMDL());
		try {
			m1.setValues(new Integer[]{10,11});
			Assert.fail();
		} catch (Exception e) { }
		try {
			m1.setValues(new Integer[]{10});
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertArrayEquals(new Integer[]{10}, m1.getValues());
	}

}
