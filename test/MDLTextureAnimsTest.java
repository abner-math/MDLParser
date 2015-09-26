

import org.junit.Assert;
import org.junit.Test;

import io.github.picoledelimao.mdl.MDLTextureAnims;

public class MDLTextureAnimsTest {

	@Test
	public void test() throws NoSuchMethodException, SecurityException {
		String s1 = "TextureAnims 3 {\n\tTVertexAnim {\n\t\tTranslation 2 {\n\t\t\tHermite,\n\t\t\t0: { 0, 0, 0 },\n\t\t\t\tInTan { 0, 0, 0 },\n\t\t\t\tOutTan { 0, 0, 0 },\n\t\t\t50: { 10, 10, 10 },\n\t\t\t\tInTan { 0, 0, 0 },\n\t\t\t\tOutTan { 0, 0, 0 },\n\t\t}\n\t\tRotation 2 {\n\t\t\tDontInterp,\n\t\t\tGlobalSeqId 0,\n\t\t\t0: { 0, 0, 0, 1 },\n\t\t\t1010: { 50, 50, 50, 50 },\n\t\t}\n\t\tScaling 2 {\n\t\t\tDontInterp,\n\t\t\tGlobalSeqId 0,\n\t\t\t0: { 1, 1, 1 },\n\t\t\t10: { 0, 0, 0 },\n\t\t}\n\t}\n\tTVertexAnim {\n\t}\n\tTVertexAnim {\n\t\tTranslation 2 {\n\t\t\tDontInterp,\n\t\t\t0: { 0, 0, 0 },\n\t\t\t10: { 10, 10, 10 },\n\t\t}\n\t\tScaling 2 {\n\t\t\tHermite,\n\t\t\tGlobalSeqId 0,\n\t\t\t0: { 1, 1, 1 },\n\t\t\t\tInTan { 0, 0, 0 },\n\t\t\t\tOutTan { 0, 0, 0 },\n\t\t\t100: { 10, 10, 10 },\n\t\t\t\tInTan { 0, 0, 0 },\n\t\t\t\tOutTan { 0, 0, 0 },\n\t\t}\n\t}\n}\n";
		MDLTextureAnims anims1 = new MDLTextureAnims();
		try {
			anims1.parse(s1);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertEquals(s1, anims1.toMDL());
	}

}
