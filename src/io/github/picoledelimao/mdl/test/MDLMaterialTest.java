package io.github.picoledelimao.mdl.test;

import org.junit.Assert;
import org.junit.Test;

import io.github.picoledelimao.mdl.MDLMaterial;

public class MDLMaterialTest {

	@Test
	public void test() throws NoSuchMethodException, SecurityException {
		String s1 = "Material {\n\tConstantColor,\n\tSortPrimsFarZ,\n\tFullResolution,\n\tPriorityPlane 22,\n\tLayer {\n\t\tFilterMode Modulate,\n\t\tAlpha 4 {\n\t\t\tBezier,\n\t\t\tGlobalSeqId 0,\n\t\t\t0: 10,\n\t\t\t\tInTan 0,\n\t\t\t\tOutTan 0,\n\t\t\t100: 50,\n\t\t\t\tInTan 0,\n\t\t\t\tOutTan 0,\n\t\t\t150: 50,\n\t\t\t\tInTan 70,\n\t\t\t\tOutTan 770,\n\t\t\t170: 50,\n\t\t\t\tInTan 10,\n\t\t\t\tOutTan 110,\n\t\t}\n\t\tTextureID 1 {\n\t\t\tDontInterp,\n\t\t\t0: 0,\n\t\t}\n\t\tTwoSided,\n\t\tUnshaded,\n\t\tUnfogged,\n\t\tSphereEnvMap,\n\t\tNoDepthTest,\n\t\tNoDepthSet,\n\t}\n}\n";
		MDLMaterial m1 = new MDLMaterial();
		try {
			m1.parse(s1);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertEquals(s1, m1.toMDL());
		String s2 = "Material {\n\tLayer {\n\t\tFilterMode Additive,\n\t\tAlpha 1 {\n\t\t\tBezier,\n\t\t\tGlobalSeqId 0,\n\t\t\t0: 0.5,\n\t\t\t\tInTan 10,\n\t\t\t\tOutTan 15,\n\t\t}\n\t\tstatic TextureID 0,\n\t\tTwoSided,\n\t\tUnshaded,\n\t}\n\tLayer {\n\t\tFilterMode None,\n\t\tstatic TextureID 0,\n\t}\n}\n";
		MDLMaterial m2 = new MDLMaterial();
		try {
			m2.parse(s2);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertEquals(s2, m2.toMDL());
	}

}
