

import java.lang.reflect.InvocationTargetException;

import org.junit.Assert;
import org.junit.Test;

import io.github.picoledelimao.mdl.MDLParticleEmitter;
import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;

public class MDLParticleEmitterTest {

	@Test
	public void test() throws MDLNotFoundException, MDLParserErrorException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		String s1 = "ParticleEmitter \"UNNAMED\" {\n\tObjectId 30,\n\tEmitterUsesMDL,\n\tEmitterUsesTGA,\n\tEmissionRate 2 {\n\t\tDontInterp,\n\t\t0: 0,\n\t\t10: 100,\n\t}\n\tstatic Gravity 100,\n\tstatic Longitude 100,\n\tstatic Latitude 100,\n\tstatic Visibility 0.5,\n\tParticle {\n\t\tstatic LifeSpan 0,\n\t\tstatic InitVelocity 10.2,\n\t\tPath \"\",\n\t}\n\tDontInherit { Translation, Rotation, Scaling },\n\tBillboarded,\n\tBillboardedLockX,\n\tBillboardedLockY,\n\tBillboardedLockZ,\n\tCameraAnchored,\n}\n";
		MDLParticleEmitter p1 = new MDLParticleEmitter();
		p1.parse(s1);
		Assert.assertEquals(s1, p1.toMDL());
		String s2 = "ParticleEmitter \"UNNAMED\" {\n\tObjectId 31,\n\tstatic EmissionRate 0,\n\tGravity 2 {\n\t\tDontInterp,\n\t\t0: 0,\n\t\t100: 10,\n\t}\n\tstatic Longitude 0,\n\tLatitude 2 {\n\t\tHermite,\n\t\t0: 0,\n\t\t\tInTan 0,\n\t\t\tOutTan 0,\n\t\t80: 1000,\n\t\t\tInTan 0,\n\t\t\tOutTan 0,\n\t}\n\tParticle {\n\t\tLifeSpan 2 {\n\t\t\tBezier,\n\t\t\tGlobalSeqId 0,\n\t\t\t0: 0,\n\t\t\t\tInTan 0,\n\t\t\t\tOutTan 0,\n\t\t\t10: 80,\n\t\t\t\tInTan 0,\n\t\t\t\tOutTan 0,\n\t\t}\n\t\tstatic InitVelocity 0,\n\t\tPath \"sdmsa.mdx\",\n\t}\n}\n";
		MDLParticleEmitter p2 = new MDLParticleEmitter();
		p2.parse(s2);
		Assert.assertEquals(s2, p2.toMDL());
	} 

}
