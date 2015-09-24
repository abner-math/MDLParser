package io.github.pcioledelimao.mdl;

import io.github.picoledelimao.mdl.core.MDLArray;
import io.github.picoledelimao.mdl.core.MDLNumber;

public class MDLGlobalSequences extends MDLArray<MDLNumber> {

	public MDLGlobalSequences() throws NoSuchMethodException, SecurityException {
		super("GlobalSequences", true, MDLNumber.class.getDeclaredConstructor(String.class, Number.class, Boolean.class), "Duration", 0, false);
	}
	
}
