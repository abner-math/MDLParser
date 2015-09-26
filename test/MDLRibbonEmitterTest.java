import java.lang.reflect.InvocationTargetException;

import org.junit.Assert;
import org.junit.Test;

import io.github.picoledelimao.mdl.MDLRibbonEmitter;
import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;

public class MDLRibbonEmitterTest {

	@Test
	public void test() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, MDLNotFoundException, MDLParserErrorException {
		String s1 = "RibbonEmitter \"UNNAMED\" {\n\tObjectId 34,\n\tstatic HeightAbove 100,\n\tstatic HeightBelow 199,\n\tstatic Alpha 0.5,\n\tstatic Color { 0.501961, 0, 0 },\n\tstatic TextureSlot 12,\n\tstatic Visibility 0.5,\n\tEmissionRate 10,\n\tLifeSpan 5,\n\tGravity 10,\n\tRows 12,\n\tColumns 12,\n\tMaterialID 0,\n\tDontInherit { Translation, Rotation, Scaling },\n\tBillboarded,\n\tBillboardedLockX,\n\tBillboardedLockY,\n\tBillboardedLockZ,\n\tCameraAnchored,\n}\n";
		MDLRibbonEmitter ribbon1 = new MDLRibbonEmitter();
		ribbon1.parse(s1);
		Assert.assertEquals(s1, ribbon1.toMDL());
		String s2 = "RibbonEmitter \"UNNAMED\" {\n\tObjectId 35,\n\tstatic HeightAbove 0,\n\tstatic HeightBelow 0,\n\tstatic Alpha 1,\n\tstatic Color { 1, 1, 1 },\n\tstatic TextureSlot 0,\n\tEmissionRate 0,\n\tLifeSpan 0,\n\tRows 1,\n\tColumns 1,\n}\n";
		MDLRibbonEmitter ribbon2 = new MDLRibbonEmitter();
		ribbon2.parse(s2);
		Assert.assertEquals(s2, ribbon2.toMDL());
	}

}
