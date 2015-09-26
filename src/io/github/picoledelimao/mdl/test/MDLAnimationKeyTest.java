package io.github.picoledelimao.mdl.test;

import java.lang.reflect.InvocationTargetException;

import org.junit.Assert;
import org.junit.Test;

import io.github.picoledelimao.mdl.MDLAnimationKey;
import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLNumber;
import io.github.picoledelimao.mdl.core.MDLNumberArray;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;
import io.github.picoledelimao.mdl.core.Pair;

public class MDLAnimationKeyTest {

	@Test
	public void test() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, MDLNotFoundException, MDLParserErrorException {
		String s1 = "oikkk 5: 10,\n20: 40,";
		MDLAnimationKey<MDLNumber> frame = new MDLAnimationKey<>(false, MDLNumber.class.getConstructor(String.class, Number.class, Boolean.class), new Integer(0), true);
		Pair<String, String> token = frame.parse(s1);
		Assert.assertEquals(5, frame.getKey(), 0);
		Assert.assertEquals(10, (int)frame.getValue().getValue(), 0);
		Assert.assertEquals("5: 10,\n", frame.toMDL());
		token = frame.parse(token.first);
		Assert.assertEquals(20, frame.getKey(), 0);
		Assert.assertEquals(40, (int)frame.getValue().getValue(), 0);
		Assert.assertEquals("20: 40,\n", frame.toMDL());
		String s2 = "idsoaodas 100: {10,20, 30}, 200: {50, 100, 150},";
		MDLAnimationKey<MDLNumberArray> frame2 = new MDLAnimationKey<>(false, MDLNumberArray.class.getConstructor(String.class, Class.class, Integer.class), Float.class, 3);
		token = frame2.parse(s2);
		Assert.assertEquals(100, frame2.getKey(), 0);
		Assert.assertArrayEquals(new Float[]{10f, 20f, 30f}, (Float[])frame2.getValue().getValues());
		Assert.assertEquals("100: { 10, 20, 30 },\n", frame2.toMDL());
		token = frame2.parse(token.first);
		Assert.assertEquals(200, frame2.getKey(), 0);
		Assert.assertArrayEquals(new Float[]{50f, 100f, 150f}, (Float[])frame2.getValue().getValues());
		Assert.assertEquals("200: { 50, 100, 150 },\n", frame2.toMDL());
		String s3 = "0: 10,\n InTan: 8, OutTan: 12, 1: 15, InTan: 14, OutTan: 20,";
		MDLAnimationKey<MDLNumber> frame3 = new MDLAnimationKey<>(true, MDLNumber.class.getConstructor(String.class, Number.class, Boolean.class), new Integer(0), true);
		frame3.parse(s3);
		Assert.assertEquals(0, frame3.getKey(), 0);
		Assert.assertEquals(10, frame3.getValue().getValue());
		Assert.assertEquals(8, frame3.getTanValue().first.getValue());
		Assert.assertEquals(12, frame3.getTanValue().second.getValue());
		Assert.assertEquals("0: 10,\n\tInTan 8,\n\tOutTan 12,\n", frame3.toMDL());
	} 

}
