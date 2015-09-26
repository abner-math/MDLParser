package io.github.picoledelimao.mdl.test;

import org.junit.Assert;
import org.junit.Test;

import io.github.picoledelimao.mdl.MDLLayer;
import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;

public class MDLLayerTest {

	@Test
	public void test() throws MDLNotFoundException, MDLParserErrorException {
		String s1 = "Layer {\n\tFilterMode Modulate,\n\tAlpha 4 {\n\t\tBezier,\n\t\tGlobalSeqId 0,\n\t\t0: 10,\n\t\t\tInTan 0,\n\t\t\tOutTan 0,\n\t\t100: 50,\n\t\t\tInTan 0,\n\t\t\tOutTan 0,\n\t\t150: 50,\n\t\t\tInTan 70,\n\t\t\tOutTan 770,\n\t\t170: 50,\n\t\t\tInTan 10,\n\t\t\tOutTan 110,\n\t}\n\tTextureID 1 {\n\t\tDontInterp,\n\t\t0: 0,\n\t}\n\tTwoSided,\n\tUnshaded,\n\tUnfogged,\n\tSphereEnvMap,\n\tNoDepthTest,\n\tNoDepthSet,\n}\n";
		MDLLayer layer1 = new MDLLayer();
		layer1.parse(s1);
		Assert.assertEquals(s1, layer1.toMDL());
		String s2 = "Layer {\n\tFilterMode Additive,\n\tAlpha 1 {\n\t\tBezier,\n\t\tGlobalSeqId 0,\n\t\t0: 0.5,\n\t\t\tInTan 10,\n\t\t\tOutTan 15,\n\t}\n\tstatic TextureID 0,\n\tTwoSided,\n\tUnshaded,\n}\n";
		MDLLayer layer2 = new MDLLayer();
		layer2.parse(s2);
		Assert.assertEquals(s2, layer2.toMDL());
		String s3 = "Layer {\n\tFilterMode None,\n\tstatic TextureID 0,\n}\n";
		MDLLayer layer3 = new MDLLayer();
		layer3.parse(s3);
		Assert.assertEquals(s3, layer3.toMDL());
	}

}
