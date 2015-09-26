package io.github.picoledelimao.mdl.test;

import java.lang.reflect.InvocationTargetException;

import org.junit.Assert;
import org.junit.Test;

import io.github.picoledelimao.mdl.MDLGeosetAnim;
import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;

public class MDLGeosetAnimTest {

	@Test
	public void test() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, MDLNotFoundException, MDLParserErrorException {
		String s1 = "GeosetAnim {\n\tGeosetId 0,\n\tAlpha 1 {\n\t\tHermite,\n\t\t0: 0.5,\n\t\t\tInTan 0,\n\t\t\tOutTan 0,\n\t}\n\tColor 1 {\n\t\tDontInterp,\n\t\t0: { 0, 0, 1 },\n\t}\n\tDropShadow,\n}\n";
		MDLGeosetAnim anim1 = new MDLGeosetAnim();
		anim1.parse(s1);
		Assert.assertEquals(s1, anim1.toMDL());
		String s2 = "GeosetAnim {\n}\n";
		MDLGeosetAnim anim2 = new MDLGeosetAnim();
		anim2.parse(s2);
		Assert.assertEquals(s2, anim2.toMDL());
	}

}
