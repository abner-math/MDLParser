package io.github.picoledelimao.mdl;

import io.github.picoledelimao.mdl.core.MDLObjectArray;

public class MDLSequences extends MDLObjectArray<MDLAnim> {

	public MDLSequences() throws NoSuchMethodException, SecurityException {
		super("Sequences", true, MDLAnim.class.getDeclaredConstructor());
	}

}
