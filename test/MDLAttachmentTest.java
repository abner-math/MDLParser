

import java.lang.reflect.InvocationTargetException;

import org.junit.Assert;
import org.junit.Test;

import io.github.picoledelimao.mdl.MDLAttachment;
import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;

public class MDLAttachmentTest {

	@Test
	public void test() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, MDLNotFoundException, MDLParserErrorException {
		String s1 = "Attachment \"Origin Ref\" {\n\tObjectId 27,\n\tParent 18,\n\tAttachmentID 5,\n\tPath \"sfdsdf\",\n\tVisibility 2 {\n\t\tDontInterp,\n\t\t0: 1,\n\t\t10: 100,\n\t}\n\tDontInherit { Translation, Rotation, Scaling },\n\tBillboarded,\n\tBillboardedLockX,\n\tBillboardedLockY,\n\tBillboardedLockZ,\n\tCameraAnchored,\n\tTranslation 2 {\n\t\tDontInterp,\n\t\t0: { 0, 0, 0 },\n\t\t100: { 1, 1, 1 },\n\t}\n}\n";
		MDLAttachment att1 = new MDLAttachment();
		att1.parse(s1);
		Assert.assertEquals(s1, att1.toMDL());
		String s2 = "Attachment \"Chest Ref\" {\n\tObjectId 26,\n\tParent 14,\n\tAttachmentID 4,\n}\n";
		MDLAttachment att2 = new MDLAttachment();
		att2.parse(s2);
		Assert.assertEquals(s2, att2.toMDL());
		String s3 = "Attachment \"Head Ref\" {\n\tObjectId 28,\n\tParent 10,\n\tAttachmentID 6,\n\tVisibility 2 {\n\t\tHermite,\n\t\t0: 1,\n\t\t\tInTan 0,\n\t\t\tOutTan 0,\n\t\t10: 10,\n\t\t\tInTan 0,\n\t\t\tOutTan 0,\n\t}\n}\n";
		MDLAttachment att3 = new MDLAttachment();
		att3.parse(s3);
		Assert.assertEquals(s3, att3.toMDL());
	}

}
