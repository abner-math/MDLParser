import java.lang.reflect.InvocationTargetException;

import org.junit.Assert;
import org.junit.Test;

import io.github.picoledelimao.mdl.MDLParticleEmitter2;
import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;

public class MDLParticleEmitter2Test {

	@Test
	public void test() throws MDLNotFoundException, MDLParserErrorException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		String s1 = "ParticleEmitter2 \"UNNAMED\" {\n\tObjectId 32,\n\tAlphaKey,\n\tstatic Speed 1221,\n\tstatic Variation 2121,\n\tstatic Latitude 2121,\n\tstatic Gravity 2121,\n\tstatic EmissionRate 2121,\n\tstatic Width 2121,\n\tstatic Length 2121,\n\tstatic Visibility 22,\n\tSegmentColor {\n\t\tColor { 1, 1, 1 },\n\t\tColor { 1, 1, 1 },\n\t\tColor { 1, 1, 1 },\n\t},\n\tAlpha { 254.5, 255, 255 },\n\tParticleScaling { 21.5, 21.1, 21 },\n\tLifeSpanUVAnim { 21, 21, 2112 },\n\tDecayUVAnim { 2, 45, 555 },\n\tTailUVAnim { 677, 88, 999 },\n\tTailDecayUVAnim { 99, 432, 342324 },\n\tRows 2121,\n\tColumns 1221,\n\tTextureID 0,\n\tTime 21.5,\n\tLifeSpan 2121,\n\tTailLength 21,\n\tSortPrimsFarZ,\n\tLineEmitter,\n\tModelSpace,\n\tUnshaded,\n\tUnfogged,\n\tXYQuad,\n\tSquirt,\n\tBoth,\n\tDontInherit { Translation, Rotation, Scaling },\n\tBillboarded,\n\tBillboardedLockX,\n\tBillboardedLockY,\n\tBillboardedLockZ,\n\tCameraAnchored,\n}\n";
		MDLParticleEmitter2 p1 = new MDLParticleEmitter2();
		p1.parse(s1);
		Assert.assertEquals(s1, p1.toMDL());
		String s2 = "ParticleEmitter2 \"UNNAMED222\" {\n\tObjectId 33,\n\tstatic Speed 0,\n\tstatic Variation 0,\n\tstatic Latitude 0,\n\tstatic Gravity 0,\n\tstatic EmissionRate 0,\n\tstatic Width 0,\n\tstatic Length 0,\n\tSegmentColor {\n\t\tColor { 1, 1, 1 },\n\t\tColor { 1, 1, 1 },\n\t\tColor { 1, 1, 1 },\n\t},\n\tAlpha { 255, 255, 255 },\n\tParticleScaling { 1, 1, 1 },\n\tLifeSpanUVAnim { 0, 0, 1 },\n\tDecayUVAnim { 0, 0, 1 },\n\tTailUVAnim { 0, 0, 1 },\n\tTailDecayUVAnim { 0, 0, 1 },\n\tRows 1,\n\tColumns 1,\n}\n";
		MDLParticleEmitter2 p2 = new MDLParticleEmitter2();
		p2.parse(s2);
		Assert.assertEquals(s2, p2.toMDL());
		String s3 = "ParticleEmitter2 \"UNNAMED222\" {\n\tObjectId 33,\n\tstatic Speed 0,\n\tstatic Variation 0,\n\tstatic Latitude 0,\n\tstatic Gravity 0,\n\tstatic EmissionRate 0,\n\tstatic Width 0,\n\tstatic Length 0,\n\tSegmentColor {\n\t\tColor { 1, 1, 1 },\n\t\tColor { 1, 1, 1 },\n\t\tColor { 1, 1, 1 },\n\t},\n\tAlpha { 255, 255, 255 },\n\tParticleScaling { 1, 1, 1 },\n\tLifeSpanUVAnim { 0, 0, 1 },\n\tDecayUVAnim { 0, 0, 1 },\n\tTailUVAnim { 0, 0, 1 },\n\tTailDecayUVAnim { 0, 0, 1 },\n}\n";
		MDLParticleEmitter2 p3 = new MDLParticleEmitter2();
		p3.parse(s3);
		Assert.assertEquals(s3, p3.toMDL());
	}

}
