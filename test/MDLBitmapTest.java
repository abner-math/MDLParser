

import org.junit.Assert;
import org.junit.Test;

import io.github.picoledelimao.mdl.MDLBitmap;
import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;

public class MDLBitmapTest {

	@Test
	public void test() throws MDLNotFoundException, MDLParserErrorException {
		String bitmap1 = "Bitmap {\n\tImage \"\",\n\tReplaceableId 2,\n}\n";
		String bitmap2 = "Bitmap {\n\tImage \"juugo neilc.BLP\",\n\tReplaceableId 2,\n\tWrapWidth,\n\tWrapHeight,\n}\n";
		String bitmap3 = "Bitmap {\n\tImage \"juugo cs2 neilc.blp\",\n}\n";
		MDLBitmap b1 = new MDLBitmap();
		b1.parse(bitmap1);
		Assert.assertEquals(bitmap1, b1.toMDL());
		Assert.assertEquals("", b1.getImage());
		Assert.assertEquals(2, b1.getReplaceableId(), 0);
		Assert.assertFalse(b1.isWrapWidth());
		Assert.assertFalse(b1.isWrapHeight());
		MDLBitmap b2 = new MDLBitmap();
		b2.parse(bitmap2);
		Assert.assertEquals(bitmap2, b2.toMDL());
		MDLBitmap b3 = new MDLBitmap();
		b3.parse(bitmap3);
		Assert.assertEquals(bitmap3, b3.toMDL());
	}

}
