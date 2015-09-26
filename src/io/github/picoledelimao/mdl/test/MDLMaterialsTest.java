package io.github.picoledelimao.mdl.test;

import org.junit.Assert;
import org.junit.Test;

import io.github.picoledelimao.mdl.MDLMaterials;

public class MDLMaterialsTest {

	@Test
	public void test() throws NoSuchMethodException, SecurityException {
		String s1 = "Materials 2 {\n\tMaterial {\n\t\tConstantColor,\n\t\tSortPrimsFarZ,\n\t\tFullResolution,\n\t\tPriorityPlane 22,\n\t\tLayer {\n\t\t\tFilterMode Modulate,\n\t\t\tAlpha 4 {\n\t\t\t\tBezier,\n\t\t\t\tGlobalSeqId 0,\n\t\t\t\t0: 10,\n\t\t\t\t\tInTan 0,\n\t\t\t\t\tOutTan 0,\n\t\t\t\t100: 50,\n\t\t\t\t\tInTan 0,\n\t\t\t\t\tOutTan 0,\n\t\t\t\t150: 50,\n\t\t\t\t\tInTan 70,\n\t\t\t\t\tOutTan 770,\n\t\t\t\t170: 50,\n\t\t\t\t\tInTan 10,\n\t\t\t\t\tOutTan 110,\n\t\t\t}\n\t\t\tTextureID 1 {\n\t\t\t\tDontInterp,\n\t\t\t\t0: 0,\n\t\t\t}\n\t\t\tTwoSided,\n\t\t\tUnshaded,\n\t\t\tUnfogged,\n\t\t\tSphereEnvMap,\n\t\t\tNoDepthTest,\n\t\t\tNoDepthSet,\n\t\t}\n\t}\n\tMaterial {\n\t\tLayer {\n\t\t\tFilterMode Additive,\n\t\t\tAlpha 1 {\n\t\t\t\tBezier,\n\t\t\t\tGlobalSeqId 0,\n\t\t\t\t0: 0.5,\n\t\t\t\t\tInTan 10,\n\t\t\t\t\tOutTan 15,\n\t\t\t}\n\t\t\tstatic TextureID 0,\n\t\t\tTwoSided,\n\t\t\tUnshaded,\n\t\t}\n\t\tLayer {\n\t\t\tFilterMode None,\n\t\t\tstatic TextureID 0,\n\t\t}\n\t}\n}\n";
		MDLMaterials m1 = new MDLMaterials();
		try {
			m1.parse(s1);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertEquals(s1, m1.toMDL());
		String s2 = "Materials 2 {\n\tMaterial {\n\t\tLayer {\n\t\t\tFilterMode None,\n\t\t\tstatic TextureID 1,\n\t\t\tTwoSided,\n\t\t\tUnshaded,\n\t\t}\n\t}\n\tMaterial {\n\t\tLayer {\n\t\t\tFilterMode Additive,\n\t\t\tTwoSided,\n\t\t\tUnshaded,\n\t\t}\n\t}\n}\n";
		MDLMaterials m2 = new MDLMaterials();
		try {
			m2.parse(s2);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertEquals(s2, m2.toMDL());
		String s3 = "Materials 5 {\n\tMaterial {\n\t\tLayer {\n\t\t\tFilterMode None,\n\t\t\tstatic TextureID 0,\n\t\t\tTwoSided,\n\t\t\tUnshaded,\n\t\t}\n\t\tLayer {\n\t\t\tFilterMode Blend,\n\t\t\tstatic TextureID 1,\n\t\t\tTwoSided,\n\t\t}\n\t}\n\tMaterial {\n\t\tLayer {\n\t\t\tFilterMode Transparent,\n\t\t\tstatic TextureID 1,\n\t\t}\n\t}\n\tMaterial {\n\t\tLayer {\n\t\t\tFilterMode Transparent,\n\t\t\tstatic TextureID 1,\n\t\t\tTwoSided,\n\t\t}\n\t}\n\tMaterial {\n\t\tLayer {\n\t\t\tFilterMode Additive,\n\t\t\tAlpha 1 {\n\t\t\t\tLinear,\n\t\t\t\t3333: 0.75,\n\t\t\t}\n\t\t\tstatic TextureID 2,\n\t\t\tUnshaded,\n\t\t}\n\t}\n\tMaterial {\n\t\tLayer {\n\t\t\tFilterMode Additive,\n\t\t\tstatic TextureID 4,\n\t\t\tTwoSided,\n\t\t\tUnshaded,\n\t\t}\n\t}\n}\n";
		MDLMaterials m3 = new MDLMaterials();
		try {
			m3.parse(s3);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertEquals(s3, m3.toMDL());
	}

}
