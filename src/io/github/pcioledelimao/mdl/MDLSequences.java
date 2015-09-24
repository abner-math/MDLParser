package io.github.pcioledelimao.mdl;

import io.github.picoledelimao.mdl.core.MDLArray;

public class MDLSequences extends MDLArray<MDLAnim> {

	public MDLSequences() throws NoSuchMethodException, SecurityException {
		super("Sequences", true, MDLAnim.class.getDeclaredConstructor());
	}

}
