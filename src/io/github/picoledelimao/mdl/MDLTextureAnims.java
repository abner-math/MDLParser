package io.github.picoledelimao.mdl;

import io.github.picoledelimao.mdl.core.MDLObjectArray;

public class MDLTextureAnims extends MDLObjectArray<MDLTVertexAnim> {

	public MDLTextureAnims() throws NoSuchMethodException, SecurityException {
		super("TextureAnims", true, MDLTVertexAnim.class.getDeclaredConstructor(String.class), "TVertexAnim");
	}

}
