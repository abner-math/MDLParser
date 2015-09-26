package io.github.picoledelimao.mdl;

import io.github.picoledelimao.mdl.core.MDLObjectArray;

public class MDLTextures extends MDLObjectArray<MDLBitmap> {

	public MDLTextures() throws NoSuchMethodException, SecurityException {
		super("Textures", true, MDLBitmap.class.getDeclaredConstructor());
	}

}
