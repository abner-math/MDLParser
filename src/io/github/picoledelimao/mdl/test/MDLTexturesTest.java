package io.github.picoledelimao.mdl.test;

import org.junit.Assert;
import org.junit.Test;

import io.github.pcioledelimao.mdl.MDLTextures;

public class MDLTexturesTest {

	@Test
	public void test() throws NoSuchMethodException, SecurityException {
		String textures1 = "Textures 3 {\n\tBitmap {\n\t\tImage \"\",\n\t\tReplaceableId 2,\n\t}\n\tBitmap {\n\t\tImage \"juugo neilc.BLP\",\n\t\tReplaceableId 2,\n\t\tWrapWidth,\n\t\tWrapHeight,\n\t}\n\tBitmap {\n\t\tImage \"juugo cs2 neilc.blp\",\n\t}\n}\n";
		String textures2 = "Textures 5 {\n\tBitmap {\n\t\tImage \"\",\n\t\tReplaceableId 1,\n\t}\n\tBitmap {\n\t\tImage \"Textures\\Arthas.blp\",\n\t}\n\tBitmap {\n\t\tImage \"\",\n\t\tReplaceableId 2,\n\t}\n\tBitmap {\n\t\tImage \"Textures\\Yellow_Star_Dim.blp\",\n\t}\n\tBitmap {\n\t\tImage \"Textures\\RibbonBlur1.blp\",\n\t}\n}\n";
		MDLTextures t1 = new MDLTextures();
		try {
			t1.parse(textures1);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertEquals(t1.toMDL(), textures1);
		MDLTextures t2 = new MDLTextures();
		try {
			t2.parse(textures2);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertEquals(t2.toMDL(), textures2);
	}

}
