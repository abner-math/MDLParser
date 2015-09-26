package io.github.picoledelimao.mdl;

import io.github.picoledelimao.mdl.core.MDLObjectArray;

public class MDLMaterials extends MDLObjectArray<MDLMaterial> {

	public MDLMaterials() throws NoSuchMethodException, SecurityException {
		super("Materials", true, MDLMaterial.class.getDeclaredConstructor());
	}

}
