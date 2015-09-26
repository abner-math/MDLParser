package io.github.picoledelimao.mdl.test;

import java.lang.reflect.InvocationTargetException;

import org.junit.Assert;
import org.junit.Test;

import io.github.picoledelimao.mdl.MDLParticle;
import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;

public class MDLParticleTest {

	@Test
	public void test() throws MDLNotFoundException, MDLParserErrorException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		String s1 = "Particle {\n\tstatic LifeSpan 0,\n\tstatic InitVelocity 10.2,\n\tPath \"\",\n}\n";
		MDLParticle p1 = new MDLParticle();
		p1.parse(s1);
		Assert.assertEquals(s1, p1.toMDL());
		String s2 = "Particle {\n\tLifeSpan 2 {\n\t\tBezier,\n\t\tGlobalSeqId 0,\n\t\t0: 0,\n\t\t\tInTan 0,\n\t\t\tOutTan 0,\n\t\t10: 80,\n\t\t\tInTan 0,\n\t\t\tOutTan 0,\n\t}\n\tstatic InitVelocity 0,\n\tPath \"sdmsa.mdx\",\n}\n";
		MDLParticle p2 = new MDLParticle();
		p2.parse(s2);
		Assert.assertEquals(s2, p2.toMDL());
	}

}
