package io.github.picoledelimao.mdl.test;

import java.lang.reflect.InvocationTargetException;

import org.junit.Assert;
import org.junit.Test;

import io.github.picoledelimao.mdl.MDLAnimationKeys;
import io.github.picoledelimao.mdl.MDLInterpolationType;
import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLNumber;
import io.github.picoledelimao.mdl.core.MDLNumberArray;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;

public class MDLAnimationKeysTest {

	@Test
	public void test() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, MDLParserErrorException, MDLNotFoundException {
		String s1 = "Alpha 2 {\n\tDontInterp,\n\tGlobalSeqId 0,\n\t0: 10,\n\t100: 50,\n}\n";
		MDLAnimationKeys<MDLNumber> frames = new MDLAnimationKeys<MDLNumber>("Alpha", MDLNumber.class.getDeclaredConstructor(String.class, Number.class, Boolean.class), new Integer(0), true);
		frames.parse(s1);
		Assert.assertEquals(s1, frames.toMDL());
		Assert.assertEquals("DontInterp", frames.getInterpolationType().toString());
		Assert.assertEquals(0, frames.getGlobalSeqId(), 0);
		String s2 = "TextureID 1 {\n\tDontInterp,\n\t0: 0,\n}\n";
		MDLAnimationKeys<MDLNumber> frames2 = new MDLAnimationKeys<MDLNumber>("TextureID", MDLNumber.class.getDeclaredConstructor(String.class, Number.class, Boolean.class), new Integer(0), true);
		frames2.parse(s2);
		Assert.assertEquals(s2, frames2.toMDL());
		String s3 = "Alpha 4 {\n\tBezier,\n\tGlobalSeqId 0,\n\t0: 10,\n\t\tInTan 0,\n\t\tOutTan 0,\n\t100: 50,\n\t\tInTan 0,\n\t\tOutTan 0,\n\t150: 50,\n\t\tInTan 70,\n\t\tOutTan 770,\n\t170: 50,\n\t\tInTan 10,\n\t\tOutTan 110,\n}\n";
		MDLAnimationKeys<MDLNumber> frames3 = new MDLAnimationKeys<MDLNumber>("Alpha", MDLNumber.class.getDeclaredConstructor(String.class, Number.class, Boolean.class), new Integer(0), true);
		frames3.parse(s3);
		Assert.assertEquals(s3, frames3.toMDL());
		frames3.setInterpolationType(MDLInterpolationType.LINEAR);
		String s4 = "Alpha 4 {\n\tLinear,\n\tGlobalSeqId 0,\n\t0: 10,\n\t100: 50,\n\t150: 50,\n\t170: 50,\n}\n";
		Assert.assertEquals(s4, frames3.toMDL());
		frames3.setInterpolationType(MDLInterpolationType.BEZIER);
		Assert.assertEquals(s3, frames3.toMDL());
		String s5 = "Translation 2 {\n\tHermite,\n\t0: { 0, 0, 0 },\n\t\tInTan { 0, 0, 0 },\n\t\tOutTan { 0, 0, 0 },\n\t50: { 10, 10, 10 },\n\t\tInTan { 0, 0, 0 },\n\t\tOutTan { 0, 0, 0 },\n}\n";
		MDLAnimationKeys<MDLNumberArray> frames4 = new MDLAnimationKeys<MDLNumberArray>("Translation", MDLNumberArray.class.getDeclaredConstructor(String.class, Class.class, Integer.class), Float.class, new Integer(3));
		frames4.parse(s5);
		Assert.assertEquals(s5, frames4.toMDL());
	}

}
