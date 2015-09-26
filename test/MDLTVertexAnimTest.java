

import java.lang.reflect.InvocationTargetException;

import org.junit.Assert;
import org.junit.Test;

import io.github.picoledelimao.mdl.MDLTVertexAnim;
import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;

public class MDLTVertexAnimTest {

	@Test
	public void test() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, MDLNotFoundException, MDLParserErrorException {
		String s1 = "TVertexAnim {\n\tTranslation 2 {\n\t\tHermite,\n\t\t0: { 0, 0, 0 },\n\t\t\tInTan { 0, 0, 0 },\n\t\t\tOutTan { 0, 0, 0 },\n\t\t50: { 10, 10, 10 },\n\t\t\tInTan { 0, 0, 0 },\n\t\t\tOutTan { 0, 0, 0 },\n\t}\n\tRotation 2 {\n\t\tDontInterp,\n\t\tGlobalSeqId 0,\n\t\t0: { 0, 0, 0, 1 },\n\t\t1010: { 50, 50, 50, 50 },\n\t}\n\tScaling 2 {\n\t\tDontInterp,\n\t\tGlobalSeqId 0,\n\t\t0: { 1, 1, 1 },\n\t\t10: { 0, 0, 0 },\n\t}\n}\n";
		MDLTVertexAnim anim1 = new MDLTVertexAnim("TVertexAnim");
		anim1.parse(s1); 
		Assert.assertEquals(s1, anim1.toMDL());
		String s2 = "TVertexAnim {\n}\n";
		MDLTVertexAnim anim2 = new MDLTVertexAnim("TVertexAnim");
		anim2.parse(s2);
		Assert.assertEquals(s2, anim2.toMDL());
		String s3 = "TVertexAnim {\n\tTranslation 2 {\n\t\tHermite,\n\t\t0: { 0, 0, 0 },\n\t\t\tInTan { 0, 0, 0 },\n\t\t\tOutTan { 0, 0, 0 },\n\t\t50: { 10, 10, 10 },\n\t\t\tInTan { 0, 0, 0 },\n\t\t\tOutTan { 0, 0, 0 },\n\t}\n\tScaling 2 {\n\t\tDontInterp,\n\t\tGlobalSeqId 0,\n\t\t0: { 1, 1, 1 },\n\t\t10: { 0, 0, 0 },\n\t}\n}\n";
		MDLTVertexAnim anim3 = new MDLTVertexAnim("TVertexAnim");
		anim3.parse(s3);
		Assert.assertEquals(s3, anim3.toMDL());
	}

}
